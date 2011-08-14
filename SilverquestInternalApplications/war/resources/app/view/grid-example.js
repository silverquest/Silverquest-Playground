Ext.require([
    'Ext.grid.*',
    'Ext.data.*',
    'Ext.form.field.Number',
    'Ext.form.field.Date',
    'Ext.tip.QuickTipManager'
]);

Ext.define('TimeSheetEntry', {
    extend: 'Ext.data.Model',
    idProperty: 'id',
    fields: [
             
        {name: 'date', type: 'date', dateFormat: 'm/d/Y'},
        {name: 'numberOfHours', type: 'int'},
        {name: 'portionOfDay', type: 'float'},
        {name: 'timeSheetId;', type: 'long'},
        {name: 'description', type: 'string'},
        {name: 'workTypeRef', type: 'string'}

    ]
});

var data = [
    {date: '06/24/2007', numberOfHours: 8, portionOfDay: 1.0, timeSheetId: 3, description: 'Worked on insurance', workTypeRef: 'NORMAL'},
    {date: '07/24/2007', numberOfHours: 8, portionOfDay: 1.0, timeSheetId: 3, description: 'Worked on insurance2', workTypeRef: 'NORMAL'},
    {date: '08/24/2007', numberOfHours: 8, portionOfDay: 1.0, timeSheetId: 3, description: 'Worked on insurance3', workTypeRef: 'NORMAL'},
    {date: '09/24/2007', numberOfHours: 8, portionOfDay: 1.0, timeSheetId: 3, description: 'Worked on insurance4', workTypeRef: 'NORMAL'},
    {date: '10/24/2007', numberOfHours: 8, portionOfDay: 1.0, timeSheetId: 3, description: 'Worked on insurance5', workTypeRef: 'NORMAL'},
    {date: '11/24/2007', numberOfHours: 8, portionOfDay: 1.0, timeSheetId: 3, description: 'Worked on insurance', workTypeRef: 'NORMAL'},
    {date: '12/24/2007', numberOfHours: 8, portionOfDay: 1.0, timeSheetId: 3, description: 'Worked on insurance', workTypeRef: 'NORMAL'} ];

Ext.onReady(function(){
    
    Ext.tip.QuickTipManager.init();
    
    var store = Ext.create('Ext.data.Store', {
        model: 'Task',
        data: data,
        sorters: {property: 'due', direction: 'ASC'},
        groupField: 'project'
    });

    var cellEditing = Ext.create('Ext.grid.plugin.CellEditing', {
        clicksToEdit: 1,
        listeners: {
            edit: function(){
                // refresh summaries
                grid.getView().refresh();
            }
        }
    });
    var showSummary = true;
    var grid = Ext.create('Ext.grid.Panel', {
        width: 800,
        height: 450,
        frame: true,
        title: 'Sponsored Projects',
        iconCls: 'icon-grid',
        renderTo: document.body,
        store: store,
        plugins: [cellEditing],
        dockedItems: [{
            dock: 'top',
            xtype: 'toolbar',
            items: [{
                tooltip: 'Toggle the visibility of the summary row',
                text: 'Toggle Summary',
                handler: function(){
                    var view = grid.getView();
                    showSummary = !showSummary;
                    view.getFeature('group').toggleSummaryRow(showSummary);
                    view.refresh();
                }
            }]
        }],
        features: [{
            id: 'group',
            ftype: 'groupingsummary',
            groupHeaderTpl: '{name}',
            hideGroupedHeader: true
        }],
        columns: [{
            text: 'Task',
            flex: 1,
            tdCls: 'task',
            sortable: true,
            dataIndex: 'description',
            hideable: false,
            summaryType: 'count',
            renderer: function(v, params) {
                params.tdCls = "task";
                return v;
            },
            summaryRenderer: function(v, params, data) {
                return ((v === 0 || v > 1) ? '(' + v + ' Tasks)' : '(1 Task)');
            }
        }, {
            header: 'Project',
            width: 20,
            sortable: true,
            dataIndex: 'project'
        }, {
            header: 'Due Date',
            width: 120,
            sortable: true,
            dataIndex: 'due',
            summaryType: 'max',
            renderer: Ext.util.Format.dateRenderer('m/d/Y'),
            field: {
                xtype: 'datefield'
            }
        }, {
            header: 'Estimate',
            width: 75,
            sortable: true,
            dataIndex: 'estimate',
            summaryType: 'sum',
            renderer: function(v){
                return v + ' hours';
            },
            field: {
                xtype: 'numberfield'
            }
        }, {
            header: 'Rate',
            width: 75,
            sortable: true,
            renderer: Ext.util.Format.usMoney,
            dataIndex: 'rate',
            summaryType: 'average',
            field: {
                xtype: 'numberfield'
            }
        }, {
            id: 'cost',
            header: 'Cost',
            width: 75,
            sortable: false,
            groupable: false,
            renderer: function(v, params, record){
                return Ext.util.Format.usMoney(record.get('estimate') * record.get('rate'));
            },
            dataIndex: 'cost',
            summaryType: function(records){
                var i = 0,
                    length = records.length,
                    total = 0,
                    record;

                for (; i < length; ++i) {
                    record = records[i];
                    total += record.get('estimate') * record.get('rate');
                }
                return total;
            },
            summaryRenderer: Ext.util.Format.usMoney
        }]
    });
});