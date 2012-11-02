(function(){
/*
Collection


 */
Oretan.Collection.Words = Backbone.Collection.extend({
	//ここにセットさせたものがCollection扱い
	//基本的にBackbone.Model.extendしたもの
	model: Oretan.Model.Word,
	url: '/word/list',
    fetchByQuery: function(query){

		var self = this;

		$.ajax({
			url: self.url,
			dataType: 'json',
		}).done(function(data){
			self.reset(data);
		}).fail(function(){
			self.trigger('error', arguments);
		});
	}
});

})();