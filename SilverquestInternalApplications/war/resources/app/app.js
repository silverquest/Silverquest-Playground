

Ext.require([
             'Ext.Window.*', 
             'Ext.grid.*',
             'Ext.data.*',
             'Ext.util.*',
             'Ext.state.*',
             'Ext.form.*',
             'Ext.dd.*',
             'Ext.Viewport.*', 
             'Ext.container.Viewport',
             'Ext.form.field.Number',
             'Ext.form.field.Date',
             'Ext.tip.QuickTipManager',

         ]);



Ext.application({
	name : 'HelloExt',
	appFolder : 'app',
	launch : function() {
		Ext.create('Ext.container.Viewport', {
			layout : 'fit',

			items : [ 
			          
			   gridX   
			   ,
			   
			   
			   {
				xtype : 'container',
				height : 847,
				region : 'center',
				items : [

				{
					xtype : 'tabpanel',
					activeTab : 0,
					items : [ {
						xtype : 'panel',
						title : 'Time Sheet'
					} ]
				},
				{
                    xtype: 'form',
                    title: 'Time Sheet Details',
                    height: 280,
                    items: [
                        {
                            xtype: 'fieldset',
                            title: '',
                            height: 45,
                            style: 'border: 0px',
                            items: [
                                {
                                    xtype: 'datefield',
                                    disabledDays: [ 0, 2, 3, 4, 5, 6],
                                    fieldLabel: 'Week Beginning',
                                    anchor: '30%',
                                    width: 70
                                }
                            ]
                        },
                        {
                            xtype: 'container',
                            height: 190,
                            layout: 'column',
                            items: [
                                {
                                    xtype: 'fieldset',
                                    title: 'Client Details',
                                    width: 400,
                                    height: 160,
                                    style: 'margin:5px;',
                                    items: [
                                        {
                                            xtype: 'textfield',
                                            fieldLabel: 'Company Name',
                                            anchor: '100%',
                                            style: 'margin: 5px;',
                                            value: companyName
                                        },
                                        {
                                            xtype: 'textarea',
                                            anchor: '100%',
                                            fieldLabel: 'Address',
                                            style: 'margin: 5px;',
                                            value: companyAddress
                                        }
                                    ]
                                },
                                {
                                    xtype: 'fieldset',
                                    title: 'Consultant Details',
                                    width: 400,
                                    height: 160,
                                    style: 'margin:5px;',
                                    items: [
                                        {
                                            xtype: 'textfield',
                                            fieldLabel: 'Name of Consultant',
                                            anchor: '100%',
                                            style: 'margin: 5px;',
                                            value: consultantFName + ' ' + consultantLName
                                        },
                                        {
                                            xtype: 'textfield',
                                            fieldLabel: 'Signature',
                                            anchor: '100%',
                                            style: 'margin: 5px;',
                                      
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                },
               //////////////
                
                ////////
                {
                    xtype: 'panel',
                    title: 'Client Confirmation',
                    height: 190,
                    items: [
                        {
                            xtype: 'form',
                            title: '',
                            height: 200,
                            items: [
                                {
                                    xtype: 'label',
                                    text: 'I am satisfied that the above stated hours have been completed by the Silverquest personnell whose name appears on this timesheet and I agree that the time has been spent engaged in work for the benefit of me and the above listed company.',
                                    height: 50
                                },
                                {
                                    xtype: 'container',
                                    height: 130,
                                    layout: 'column',
                                    items: [
                                        {
                                            xtype: 'fieldset',
                                            title: '',
                                            width: 403,
                                            height: 130,
                                            style: 'border: 0px',
                                            items: [
                                                {
                                                    xtype: 'textfield',
                                                    fieldLabel: 'Name',
                                                    anchor: '100%',
                                                    style: 'margin-bottom:30px;'
                                                },
                                                {
                                                    xtype: 'textfield',
                                                    fieldLabel: 'Title',
                                                    anchor: '100%'
                                                }
                                            ]
                                        },
                                        {
                                            xtype: 'fieldset',
                                            title: '',
                                            width: 489,
                                            height: 130,
                                            style: 'border: 0px',
                                            items: [
                                                {
                                                    xtype: 'textfield',
                                                    fieldLabel: 'Signature',
                                                    anchor: '100%',
                                                    style: 'margin-bottom:30px;margin-top:1\n0px;',
                                                    width: 400
                                                },
                                                {
                                                    xtype: 'textfield',
                                                    fieldLabel: 'Date',
                                                    anchor: '100%'
                                                }
                                            ]
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                }
                

				// end inner items
				]
			// end outter items
			} ]
		// end ext create
		});
		// end launch
	}
});