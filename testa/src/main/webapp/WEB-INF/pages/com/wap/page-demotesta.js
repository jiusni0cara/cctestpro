$package('jeecg.demotesta');
jeecg.demotesta = function(){
	var _box = null;
	var _this = {
		config:{
			event:{
				add:function(){
					$('#typeIds_combobox').combobox('reload');
					_box.handler.add();
				},
				edit:function(){
					$('#typeIds_combobox').combobox('reload');
					_box.handler.edit();
				}
			},
  			dataGrid:{
  				title:'cyy',
	   			url:'dataList.do',
	   			columns:[[
					{field:'id',checkbox:true},
					{field:'name',title:'',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.name;
							}
						},
					]]
			}
		},
		init:function(){
			_box = new YDataGrid(_this.config); 
			_box.init();
		}
	}
	return _this;
}();

$(function(){
	jeecg.demotesta.init();
});