(function(){

Oretan.View.PutForm = Backbone.View.extend({

	el: '.putForm',
	url: '/word/put',
	initialize: function(opts){
		this.collection = opts.collection;
	},
	events: {
		'submit': 'onSubmit'
	},
	onSubmit: function(e){
		e.preventDefault();

		var self = this;
		var param = {};

		$($('form').serializeArray()).each(function(i, v){
			param[v.name] = v.value;
		});

		$.ajax({
			url: self.url,
			dataType: 'json',
			data: param,
			type: 'POST'
		}).done(function(data){
			self.collection.fetchByQuery('');
		}).fail(function(){
			self.trigger('error', arguments);
		});
	}

});

})();