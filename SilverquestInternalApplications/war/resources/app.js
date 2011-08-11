Ext.application({
	name : 'AM',

	controllers : [ 'Users' ],

	views : [ 'user.List' ],

	appFolder : 'app',

	launch : function() {
		Ext.create('Ext.container.Viewport', {
			layout: 'fit',
            items: {
                xtype: 'userlist'
            }
		});
	}
});
