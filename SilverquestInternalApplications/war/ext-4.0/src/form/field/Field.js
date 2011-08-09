/**
 * @class Ext.form.field.Field

This mixin provides a common interface for the logical behavior and state of form fields, including:

- Getter and setter methods for field values
- Events and methods for tracking value and validity changes
- Methods for triggering validation

**NOTE**: When implementing custom fields, it is most likely that you will want to extend the {@link Ext.form.field.Base}
component class rather than using this mixin directly, as BaseField contains additional logic for generating an
actual DOM complete with {@link Ext.form.Labelable label and error message} display and a form input field,
plus methods that bind the Field value getters and setters to the input field's value.

If you do want to implement this mixin directly and don't want to extend {@link Ext.form.field.Base}, then
you will most likely want to override the following methods with custom implementations: {@link #getValue},
{@link #setValue}, and {@link #getErrors}. Other methods may be overridden as needed but their base
implementations should be sufficient for common cases. You will also need to make sure that {@link #initField}
is called during the component's initialization.

 * @markdown
 * @docauthor Jason Johnston <jason@sencha.com>
 */
Ext.define('Ext.form.field.Field', {

    /**
     * @property isFormField
     * @type {Boolean}
     * Flag denoting that this component is a Field. Always true.
     */
    isFormField : true,

    /**
     * @cfg {Mixed} value A value to initialize this field with (defaults to undefined).
     */
    
    /**
     * @cfg {String} name The name of the field (defaults to undefined). By default this is used as the parameter
     * name when including the {@link #getSubmitData field value} in a {@link Ext.form.Basic#submit form submit()}.
     * To prevent the field from being included in the form submit, set {@link #submitValue} to <tt>false</tt>.
     */

    /**
     * @cfg {Boolean} disabled True to disable the field (defaults to false). Disabled Fields will not be
     * {@link Ext.form.Basic#submit submitted}.</p>
     */
    disabled : false,

    /**
     * @cfg {Boolean} submitValue Setting this to <tt>false</tt> will prevent the field from being
     * {@link Ext.form.Basic#submit submitted} even when it is not disabled. Defaults to <tt>true</tt>.
     */
    submitValue: true,

    /**
     * @cfg {Boolean} validateOnChange
     * <p>Specifies whether this field should be validated immediately whenever a change in its value is detected.
     * Defaults to <tt>true</tt>. If the validation results in a change in the field's validity, a
     * {@link #validitychange} event will be fired. This allows the field to show feedback about the
     * validity of its contents immediately as the user is typing.</p>
     * <p>When set to <tt>false</tt>, feedback will not be immediate. However the form will still be validated
     * before submitting if the <tt>clientValidation</tt> option to {@link Ext.form.Basic#doAction} is
     * enabled, or if the field or form are validated manually.</p>
     * <p>See also {@link Ext.form.field.Base#checkChangeEvents}for controlling how changes to the field's value are detected.</p>
     */
    validateOnChange: true,

    /**
     * @private
     */
    suspendCheckChange: 0,

    /**
     * Initializes this Field mixin on the current instance. Components using this mixin should call
     * this method during their own initialization process.
     */
    initField: function() {
        this.addEvents(
            /**
             * @event change
             * Fires when a user-initiated change is detected in the value of the field.
             * @param {Ext.form.field.Field} this
             * @param {Mixed} newValue The new value
             * @param {Mixed} oldValue The original value
             */
            'change',
            /**
             * @event validitychange
             * Fires when a change in the field's validity is detected.
             * @param {Ext.form.field.Field} this
             * @param {Boolean} isValid Whether or not the field is now valid
             */
            'validitychange',
            /**
             * @event dirtychange
             * Fires when a change in the field's {@link #isDirty} state is detected.
             * @param {Ext.form.field.Field} this
             * @param {Boolean} isDirty Whether or not the field is now dirty
             */
            'dirtychange'
        );

        this.initValue();
    },

    /**
     * @protected
     * Initializes the field's value based on the initial config.
     */
    initValue: function() {
        var me = this;

        /**
         * @property originalValue
         * @type Mixed
         * The original value of the field as configured in the {@link #value} configuration, or as loaded by
         * the last form load operation if the form's {@link Ext.form.Basic#trackResetOnLoad trackResetOnLoad}
         * setting is <code>true</code>.
         */
        me.originalValue = me.lastValue = me.value;

        // Set the initial value - prevent validation on initial set
        me.suspendCheckChange++;
        me.setValue(me.value);
        me.suspendCheckChange--;
    },

    /**
     * Returns the {@link Ext.form.field.Field#name name} attribute of the field. This is used as the parameter
     * name when including the field value in a {@link Ext.form.Basic#submit form submit()}.
     * @return {String} name The field {@link Ext.form.field.Field#name name}
     */
    getName: function() {
        return this.name;
    },

    /**
     * Returns the current data value of the field. The type of value returned is particular to the type of the
     * particular field (e.g. a Date object for {@link Ext.form.field.Date}).
     * @return {Mixed} value The field value
     */
    getValue: function() {
        return this.value;
    },
    
    /**
     * Sets a data value into the field and runs the change detection and validation.
     * @param {Mixed} value The value to set
     * @return {Ext.form.field.Field} this
     */
    setValue: function(value) {
        var me = this;
        me.value = value;
        me.checkChange();
        return me;
    },

    /**
     * Returns whether two field {@link #getValue values} are logically equal. Field implementations may override
     * this to provide custom comparison logic appropriate for the particular field's data type.
     * @param {Mixed} value1 The first value to compare
     * @param {Mixed} value2 The second value to compare
     * @return {Boolean} True if the values are equal, false if inequal.
     */
    isEqual: function(value1, value2) {
        return String(value1) === String(value2);
    },

    /**
     * <p>Returns the parameter(s) that would be included in a standard form submit for this field. Typically this
     * will be an object with a single name-value pair, the name being this field's {@link #getName name} and the
     * value being its current stringified value. More advanced field implementations may return more than one
     * name-value pair.</p>
     * <p>Note that the values returned from this method are not guaranteed to have been successfully
     * {@link #validate validated}.</p>
     * @return {Object} A mapping of submit parameter names to values; each value should be a string, or an array
     * of strings if that particular name has multiple values. It can also return <tt>null</tt> if there are no
     * parameters to be submitted.
     */
    getSubmitData: function() {
        var me = this,
            data = null;
        if (!me.disabled && me.submitValue && !me.isFileUpload()) {
            data = {};
            data[me.getName()] = '' + me.getValue();
        }
        return data;
    },

    /**
     * <p>Returns the value(s) that should be saved to the {@link Ext.data.Model} instance for this field, when
     * {@link Ext.form.Basic#updateRecord} is called. Typically this will be an object with a single name-value
     * pair, the name being this field's {@link #getName name} and the value being its current data value. More
     * advanced field implementations may return more than one name-value pair. The returned values will be
     * saved to the corresponding field names in the Model.</p>
     * <p>Note that the values returned from this method are not guaranteed to have been successfully
     * {@link #validate validated}.</p>
     * @return {Object} A mapping of submit parameter names to values; each value should be a string, or an array
     * of strings if that particular name has multiple values. It can also return <tt>null</tt> if there are no
     * parameters to be submitted.
     */
    getModelData: function() {
        var me = this,
            data = null;
        if (!me.disabled && !me.isFileUpload()) {
            data = {};
            data[me.getName()] = me.getValue();
        }
        return data;
    },

    /**
     * Resets the current field value to the originally loaded value and clears any validation messages.
     * See {@link Ext.form.Basic}.{@link Ext.form.Basic#trackResetOnLoad trackResetOnLoad}
     */
    reset : function(){
        var me = this;
        
        me.setValue(me.originalValue);
        me.clearInvalid();
        // delete here so we reset back to the original state
        delete me.wasValid;
    },

    /**
     * Resets the field's {@link #originalValue} property so it matches the current {@link #getValue value}.
     * This is called by {@link Ext.form.Basic}.{@link Ext.form.Basic#setValues setValues} if the form's
     * {@link Ext.form.Basic#trackResetOnLoad trackResetOnLoad} property is set to true.
     */
    resetOriginalValue: function() {
        this.originalValue = this.getValue();
        this.checkDirty();
    },

    /**
     * <p>Checks whether the value of the field has changed since the last time it was checked. If the value
     * has changed, it:</p>
     * <ol>
     * <li>Fires the {@link #change change event},</li>
     * <li>Performs validation if the {@link #validateOnChange} config is enabled, firing the
     * {@link #validationchange validationchange event} if the validity has changed, and</li>
     * <li>Checks the {@link #isDirty dirty state} of the field and fires the {@link #dirtychange dirtychange event}
     * if it has changed.</li>
     * </ol>
     */
    checkChange: function() {
        if (!this.suspendCheckChange) {
            var me = this,
                newVal = me.getValue(),
                oldVal = me.lastValue;
            if (!me.isEqual(newVal, oldVal) && !me.isDestroyed) {
                me.lastValue = newVal;
                me.fireEvent('change', me, newVal, oldVal);
                me.onChange(newVal, oldVal);
            }
        }
    },

    /**
     * @private
     * Called when the field's value changes. Performs validation if the {@link #validateOnChange}
     * config is enabled, and invokes the dirty check.
     */
    onChange: function(newVal, oldVal) {
        if (this.validateOnChange) {
            this.validate();
        }
        this.checkDirty();
    },

    /**
     * <p>Returns true if the value of this Field has been changed from its {@link #originalValue}.
     * Will always return false if the field is disabled.</p>
     * <p>Note that if the owning {@link Ext.form.Basic form} was configured with
     * {@link Ext.form.Basic#trackResetOnLoad trackResetOnLoad}
     * then the {@link #originalValue} is updated when the values are loaded by
     * {@link Ext.form.Basic}.{@link Ext.form.Basic#setValues setValues}.</p>
     * @return {Boolean} True if this field has been changed from its original value (and
     * is not disabled), false otherwise.
     */
    isDirty : function() {
        var me = this;
        return !me.disabled && !me.isEqual(me.getValue(), me.originalValue);
    },

    /**
     * Checks the {@link #isDirty} state of the field and if it has changed since the last time
     * it was checked, fires the {@link #dirtychange} event.
     */
    checkDirty: function() {
        var me = this,
            isDirty = me.isDirty();
        if (isDirty !== me.wasDirty) {
            me.fireEvent('dirtychange', me, isDirty);
            me.onDirtyChange(isDirty);
            me.wasDirty = isDirty;
        }
    },

    /**
     * @private Called when the field's dirty state changes.
     * @param {Boolean} isDirty
     */
    onDirtyChange: Ext.emptyFn,

    /**
     * <p>Runs this field's validators and returns an array of error messages for any validation failures.
     * This is called internally during validation and would not usually need to be used manually.</p>
     * <p>Each subclass should override or augment the return value to provide their own errors.</p>
     * @param {Mixed} value The value to get errors for (defaults to the current field value)
     * @return {Array} All error messages for this field; an empty Array if none.
     */
    getErrors: function(value) {
        return [];
    },

    /**
     * <p>Returns whether or not the field value is currently valid by {@link #getErrors validating} the
     * field's current value. The {@link #validitychange} event will not be fired; use {@link #validate}
     * instead if you want the event to fire. <b>Note</b>: {@link #disabled} fields are always treated as valid.</p>
     * <p>Implementations are encouraged to ensure that this method does not have side-effects such as
     * triggering error message display.</p>
     * @return {Boolean} True if the value is valid, else false
     */
    isValid : function() {
        var me = this;
        return me.disabled || Ext.isEmpty(me.getErrors());
    },

    /**
     * <p>Returns whether or not the field value is currently valid by {@link #getErrors validating} the
     * field's current value, and fires the {@link #validitychange} event if the field's validity has
     * changed since the last validation. <b>Note</b>: {@link #disabled} fields are always treated as valid.</p>
     * <p>Custom implementations of this method are allowed to have side-effects such as triggering error
     * message display. To validate without side-effects, use {@link #isValid}.</p>
     * @return {Boolean} True if the value is valid, else false
     */
    validate : function() {
        var me = this,
            isValid = me.isValid();
        if (isValid !== me.wasValid) {
            me.wasValid = isValid;
            me.fireEvent('validitychange', me, isValid);
        }
        return isValid;
    },

    /**
     * A utility for grouping a set of modifications which may trigger value changes into a single
     * transaction, to prevent excessive firing of {@link #change} events. This is useful for instance
     * if the field has sub-fields which are being updated as a group; you don't want the container
     * field to check its own changed state for each subfield change.
     * @param fn A function containing the transaction code
     */
    batchChanges: function(fn) {
        this.suspendCheckChange++;
        fn();
        this.suspendCheckChange--;
        this.checkChange();
    },

    /**
     * Returns whether this Field is a file upload field; if it returns true, forms will use
     * special techniques for {@link Ext.form.Basic#submit submitting the form} via AJAX. See
     * {@link Ext.form.Basic#hasUpload} for details. If this returns true, the {@link #extractFileInput}
     * method must also be implemented to return the corresponding file input element.
     * @return {Boolean}
     */
    isFileUpload: function() {
        return false;
    },

    /**
     * Only relevant if the instance's {@link #isFileUpload} method returns true. Returns a reference
     * to the file input DOM element holding the user's selected file. The input will be appended into
     * the submission form and will not be returned, so this method should also create a replacement.
     * @return {HTMLInputElement}
     */
    extractFileInput: function() {
        return null;
    },

    /**
     * <p>Associate one or more error messages with this field. Components using this mixin should implement
     * this method to update the component's rendering to display the messages.</p>
     * <p><b>Note</b>: this method does not cause the Field's {@link #validate} or {@link #isValid} methods to
     * return <code>false</code> if the value does <i>pass</i> validation. So simply marking a Field as invalid
     * will not prevent submission of forms submitted with the {@link Ext.form.action.Submit#clientValidation}
     * option set.</p>
     * @param {String/Array} errors The error message(s) for the field.
     */
    markInvalid: Ext.emptyFn,

    /**
     * <p>Clear any invalid styles/messages for this field. Components using this mixin should implement
     * this method to update the components rendering to clear any existing messages.</p>
     * <p><b>Note</b>: this method does not cause the Field's {@link #validate} or {@link #isValid} methods to
     * return <code>true</code> if the value does not <i>pass</i> validation. So simply clearing a field's errors
     * will not necessarily allow submission of forms submitted with the {@link Ext.form.action.Submit#clientValidation}
     * option set.</p>
     */
    clearInvalid: Ext.emptyFn

});
