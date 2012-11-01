(function(){

Oretan.Model.Word = Backbone.Model.extend({

	set: function(attrs, opts){

		//modelにsetする前にhoehoeするとこ

		return Backbone.Model.prototype.set.call(this, attrs, opts);
	}
});


})();