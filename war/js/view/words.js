(function(){

Oretan.View.Words = Backbone.View.extend({
	el: '.words',
	initalize: function(){
		this.collection.on('reset', this.draw, this);
	},
	draw: function(words){
		var self = this;
		var tmpl = $('#tmpl-word').html();

		self.$el.hide().empty();
		words.each(function(word){
			var $li = _.template(tmpl, word.toJSON());
			self.$el.append($li);
		});
		self.$el.fadeIn();
	}
});

})();