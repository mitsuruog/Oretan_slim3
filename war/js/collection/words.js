(function(){

Oretan.Collection.Words = Backbone.Collection.extend({
	model: Oretan.Model.Word,
	url: '/word/list',
	fetchByQuery: function(query){

		var self = this;

		$.ajax({
			url: self.url,
			dataType: 'json',
		}).done(function(data){

			//TODO TypeError: undefined is not a function

			self.reset(data);

		}).fail(function(){
			self.trigger('error', arguments);
		});
	}
});

})();