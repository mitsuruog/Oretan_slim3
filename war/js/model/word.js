(function(){
/*
Modelはデータの設定、取得、永続化、バリデーションを行う
JavaなんかのMVCのMに当たる

Modelの属性値が変更されたらchangeイベント発生→各Viewのrenderで書くのが基本的な流れ

*/
Oretan.Model.Word = Backbone.Model.extend({

	//デフォルト
	defaults:{},
	//初期化
	initialize: function(attrs, opts){},
	//バリデーション
	//set と save で silent が false であるときに実行される。
	//知らないハマるかも・・・
	validate: function (attrs) {},
	//Modelにsetする前にhoehoeしたい場合はこんな感じで書く
	//optionで{silent: true}とするとchangeイベントが発生しない
	set: function(attrs, opts){
		//ここにhoehoeを書く
		//hoehoe～
		return Backbone.Model.prototype.set.call(this, attrs, opts);
	}

	/*
	 * 小ネタ
	 *
	 * Modelからgetする場合は、XSS対策が必要な場合はescape()が使える。
	 */

});

})();