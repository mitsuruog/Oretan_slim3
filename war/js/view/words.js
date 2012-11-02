(function(){
//Viewは特定のDOMTreeを監視して、イベントバブリングを捕捉して、ごにょごにゅする。
Oretan.View.Words = Backbone.View.extend({
	//これだとすべてクラスがこのDOMTreeを参照するので、インスタンス生成時に渡す方法もある。
	//new Oretan.View.Words({el: $('.words')});
	el: '.words',
	initialize: function(opts){
		this.collection.on('reset', this.draw, this);
		//監視しているelの下にDOMを書きたい場合はrenderを使う
		this.render();
	},
	//監視しているDOMTreeで捕捉するイベントを定義
	events:{
		'mouseover': 'mouseover',
		'mouseout': 'mouseout'
	},
	render: function(){
		console.log('render');
		this.collection.fetchByQuery('');

	    //直接DOMを書いたり、_のtemplateを使うこともできる。
		//$(this.el).html('<span class="name">foo</span><span class="text">bar</span>');
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
	},
	mouseover: function(e){
		console.log('mouseover');
	},
	mouseout: function(e){
		console.log('mouseout');
	}
});

})();