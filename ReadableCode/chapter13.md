## コードを小さく保つ

コードの短さ　≒　分かりやすさ、保守しやすさ  
**コードは出来る限り小さく、軽量に維持する**  

* YAGNI
* 身近なライブラリ、プラグインに親しむ
* 不必要なコメント、メソッドなどは消す
  
### YAGNI(You ain't gonna need it)

現段階では必要ない機能は追加しない  
YAGNI とは、機能は実際に必要となるまでは追加しないのがよいとする、エクストリーム・プログラミングにおける原則である  

「後で使うだろうという予測の元に作ったものは、実際には10%程度しか使われない。」らしいので、必要になった時に実装するようにする  

### 身近なライプラリ、プラグインに親しむ

標準ライブラリにどんなものがあるかチェックしてみるといい  
割と使いそうだけど実装するのが面倒なものは大概誰かが作ってくれているものである    

### 不必要なコメント、機能は消す

p文とか以前のコードなどのコメントアウトは消して、意味のあるコメントだけを残す  
使わなくなった機能のコードは消す  
  
昔のコードを確認したくなったらソースコード管理システムを使う  

