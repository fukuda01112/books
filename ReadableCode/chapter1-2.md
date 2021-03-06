リーダブルコードのまとめ  
初学者に向けた資料として  

# 理解しやすいコード

優れたコードの特徴はいろいろある  
  
* 簡潔である
* 短い
* 実行時間・消費メモリが小さい
* テストしやすい
* 理解しやすい
  
この中では、実行時間と短さなど、競合するものも多々あるが、  
最も重要なのが  
  
* **理解しやすい** 

という点  
常に一歩下がって、「（他人や数か月後の自分にとって）このコードは理解しやすいだろうか」と自問自答すべき

# 表面上の改善（一行ごとの改善）

## 名前に情報を詰め込む

**名前は短いコメントである**    

名前に情報を詰め込むことで、情報を多く伝えて理解されやすくする  
いい名前は、変数の目的や値を表す  
  
* 明確な単語を選ぶ
* 汎用的な名前を避ける
* 具体的な名前を選ぶ
* 接尾辞や接頭辞を使って情報を付加する
* 命名規則
  
### 明確な単語を選ぶ

**複数の意味に取れる単語は避ける**  
  
```
class Tree{
	void size();
}
```

単に```size()```だけでは、何のサイズなのかが分からない  
```height()```、```memSize()```、```numNodes()```などとすれば何のサイズを取得しているのかわかりやすい  

```Stop()```は、停止することは分かるがその後に再起動できるのかどうかが不明である  
```Kill()```、```Pause()```ならばその情報も付加することが出来る  

### 汎用的な名前を避ける

**何の意味もない名前は避ける**

tmp、retval(raturn value)、foo、aなど、意味のない汎用的な名前は避ける  

## 具体的な名前を使う  

**変数や関数などの名前は、抽象的なものでなく出来る限り具体的にする**  

```--run_locally```という、ローカル環境でデバッグをするためにデバッグログを抽出して出力する目的で使っていたオプションがある  
ローカル環境で使うのでこのままでも間違ってはいないが、知らない人はローカルで使う時必ず入れるものだと勘違いしてしまう  

  
```--debug_locally```とすればデバッグするときに用いるという情報を付加できる  
更に、```--export_dubug_log_locally```のようにすればこのオプションが具体的に何をするのかという情報まで付加できる  

### 接尾辞や接頭辞を使って情報を付加する

**知らせなけらばいけない情報は変数名に付加する**  

表示する前にエスケープしなければならないコメント  
```comment``` -> ```unescaped_comment```  
  
暗号化して扱うべきだけどまだプレインテキストなパスワード  
```password``` -> ```unencripted_password```や```plaintext_password```  

### 命名規則  

RubyやRuby on Rails固有の命名規則もあるので参照すべし  
  
https://qiita.com/gakkie/items/3afcd505c786364aa5fa  
https://qiita.com/takahashim/items/ccfd489c9b26f15b7193
  
bool型を返す関数はRubyは他と違い、  
末尾に?を付ける  
isやhasも付けない  
```is_user``` -> ```user?```  

### Tips

* スコープの大きい変数には長い名前を、短い変数には短い名前を
* 大文字やアンダースコアにも意味を含める
* 長すぎないように
