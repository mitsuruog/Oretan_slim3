var Oretan = {
	View: {},
	Model: {},
	Collection: {}
};

$(function(){

	//init model
	var words = new Oretan.Collection.Words();

	//init view
//	new Oretan.View.PutForm({
//		words: words
//	});

	new Oretan.View.Words({
		collection: words
	})

	//
	words.fetchByQuery();
});
