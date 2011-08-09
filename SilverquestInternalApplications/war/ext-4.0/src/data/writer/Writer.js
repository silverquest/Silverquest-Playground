/**
 * @author Ed Spencer
 * @class Ext.data.writer.Writer
 * @extends Object
 * 
 * <p>Base Writer class used by most subclasses of {@link Ext.data.proxy.Server}. This class is
 * responsible for taking a set of {@link Ext.data.Operation} objects and a {@link Ext.data.Request}
 * object and modifying that request based on the Operations.</p>
 * 
 * <p>For example a Ext.data.writer.Json would format the Operations and their {@link Ext.data.Model} 
 * instances based on the config options passed to the JsonWriter's constructor.</p>
 * 
 * <p>Writers are not needed for any kind of local storage - whether via a
 * {@link Ext.data.proxy.WebStorage Web Storage proxy} (see {@link Ext.data.proxy.LocalStorage localStorage}
 * and {@link Ext.data.proxy.SessionStorage sessionStorage}) or just in memory via a
 * {@link Ext.data.proxy.Memory MemoryProxy}.</p>
 * 
 * @constructor
 * @param {Object} config Optional config object
 */
Ext.define('Ext.data.writer.Writer', {
    alias: 'writer.base',
    alternateClassName: ['Ext.data.DataWriter', 'Ext.data.Writer'],
    
    /**
     * @cfg {Boolean} writeAllFields True to write all fields from the record to the server. If set to false it
     * will only send the fields that were modified. Defaults to <tt>true</tt>. Note that any fields that have
     * {@link Ext.data.Field#persist} set to false will still be ignored.
     */
    writeAllFields: true,
    
    /**
     * @cfg {String} nameProperty This property is used to read the key for each value that will be sent to the server.
     * For example:
     * <pre><code>
Ext.define('Person', {
    extend: 'Ext.data.Model',
    fields: [{
        name: 'first',
        mapping: 'firstName'
    }, {
        name: 'last',
        mapping: 'lastName'
    }, {
        name: 'age'
    }]
});
new Ext.data.writer.Writer({
    writeAllFields: true,
    nameProperty: 'mapping'
});

// This will be sent to the server
{
    firstName: 'first name value',
    lastName: 'last name value',
    age: 1
}

     * </code></pre>
     * Defaults to <tt>name</tt>. If the value is not present, the field name will always be used.
     */
    nameProperty: 'name',

    constructor: function(config) {
        Ext.apply(this, config);
    },

    /**
     * Prepares a Proxy's Ext.data.Request object
     * @param {Ext.data.Request} request The request object
     * @return {Ext.data.Request} The modified request object
     */
    write: function(request) {
        var operation = request.operation,
            records   = operation.records || [],
            len       = records.length,
            i         = 0,
            data      = [];

        for (; i < len; i++) {
            data.push(this.getRecordData(records[i]));
        }
        return this.writeRecords(request, data);
    },

    /**
     * Formats the data for each record before sending it to the server. This
     * method should be overridden to format the data in a way that differs from the default.
     * @param {Object} record The record that we are writing to the server.
     * @return {Object} An object literal of name/value keys to be written to the server.
     * By default this method returns the data property on the record.
     */
    getRecordData: function(record) {
        var isPhantom = record.phantom === true,
            writeAll = this.writeAllFields || isPhantom,
            nameProperty = this.nameProperty,
            fields = record.fields,
            data = {},
            changes,
            name,
            field,
            key;
        
        if (writeAll) {
            fields.each(function(field){
                if (field.persist) {
                    name = field[nameProperty] || field.name;
                    data[name] = record.get(field.name);
                }
            });
        } else {
            // Only write the changes
            changes = record.getChanges();
            for (key in changes) {
                if (changes.hasOwnProperty(key)) {
                    field = fields.get(key);
                    name = field[nameProperty] || field.name;
                    data[name] = changes[key];
                }
            }
            if (!isPhantom) {
                // always include the id for non phantoms
                data[record.idProperty] = record.getId();
            }
        }
        return data;
    }
});
