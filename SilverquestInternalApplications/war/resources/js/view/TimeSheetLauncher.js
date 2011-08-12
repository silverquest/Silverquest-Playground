
Ext.require([ 
    'Ext.Window.*', 
    'Ext.grid.*', 
    'Ext.data.*', 
    'Ext.dd.*',
    'Ext.Viewport.*',
    'Ext.container.Viewport'
]);


Ext.onReady(function(){


	alert("Congratulations! You have Ext configured correctly!");
	
	MyViewportUi = Ext.extend(Ext.Viewport, {
	    height: 823,
	    initComponent: function() {
	        this.items = [
	            {
	                xtype: 'container',
	                height: 847,
	                region: 'center',
	                items: [
	                    {
	                        xtype: 'tabpanel',
	                        activeTab: 0,
	                        items: [
	                            {
	                                xtype: 'panel',
	                                title: 'Time Sheet'
	                            }
	                        ]
	                    },
	                    {
	                        xtype: 'form',
	                        title: 'Time Sheet Details',
	                        height: 280,
	                        items: [
	                            {
	                                xtype: 'fieldset',
	                                title: 'Contract Assignment',
	                                height: 79,
	                                style: 'margin:5px;',
	                                items: [
	                                    {
	                                        xtype: 'datefield',
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
	                                        width: 500,
	                                        height: 160,
	                                        style: 'margin:5px;',
	                                        items: [
	                                            {
	                                                xtype: 'textfield',
	                                                fieldLabel: 'Name',
	                                                anchor: '100%',
	                                                style: 'margin: 5px;'
	                                            },
	                                            {
	                                                xtype: 'textarea',
	                                                anchor: '100%',
	                                                fieldLabel: 'Address',
	                                                style: 'margin: 5px;'
	                                            }
	                                        ]
	                                    },
	                                    {
	                                        xtype: 'fieldset',
	                                        title: 'Consultant Details',
	                                        width: 500,
	                                        height: 160,
	                                        style: 'margin:5px;',
	                                        items: [
	                                            {
	                                                xtype: 'textfield',
	                                                fieldLabel: 'Name of Consultant',
	                                                anchor: '100%',
	                                                style: 'margin: 5px;'
	                                            },
	                                            {
	                                                xtype: 'textfield',
	                                                fieldLabel: 'Signature',
	                                                anchor: '100%',
	                                                style: 'margin: 5px;'
	                                            }
	                                        ]
	                                    }
	                                ]
	                            }
	                        ]
	                    },
	                    {
	                        xtype: 'editorgrid',
	                        title: 'Time',
	                        height: 223,
	                        columns: [
	                            {
	                                xtype: 'datecolumn',
	                                dataIndex: 'date',
	                                header: 'Date',
	                                sortable: true,
	                                width: 100,
	                                editor: {
	                                    xtype: 'datefield'
	                                }
	                            },
	                            {
	                                xtype: 'gridcolumn',
	                                dataIndex: 'string',
	                                header: 'Day',
	                                sortable: true,
	                                width: 100,
	                                editor: {
	                                    xtype: 'trigger'
	                                }
	                            },
	                            {
	                                xtype: 'numbercolumn',
	                                dataIndex: 'number',
	                                header: 'Number Hours',
	                                sortable: true,
	                                width: 100,
	                                align: 'right',
	                                editor: {
	                                    xtype: 'numberfield'
	                                }
	                            },
	                            {
	                                xtype: 'gridcolumn',
	                                dataIndex: 'bool',
	                                header: 'Total Days Worked',
	                                sortable: true,
	                                width: 100,
	                                editor: {
	                                    xtype: 'textfield'
	                                }
	                            }
	                        ]
	                    },
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
	                    },
	                    {
	                        xtype: 'toolbar',
	                        height: 33,
	                        items: [
	                            {
	                                xtype: 'button',
	                                text: 'MyButton',
	                                width: 94
	                            },
	                            {
	                                xtype: 'spacer'
	                            },
	                            {
	                                xtype: 'button',
	                                text: 'MyButton'
	                            },
	                            {
	                                xtype: 'spacer'
	                            }
	                        ]
	                    }
	                ]
	            }
	        ];
	        MyViewportUi.superclass.initComponent.call(this);
	    }
	});

	MyViewportUi.render();

});