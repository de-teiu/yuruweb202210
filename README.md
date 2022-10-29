# yuruweb202210

## 概要
[ゆるWeb勉強会@札幌 OnLine #21](https://mild-web-sap.connpass.com/event/262287/)でのLT用に用意したサンプルコードです。

## 使い方

### Viteでフロントエンド側のコードをビルド
/frontend ディレクトリに移動し、以下のコマンドを実行。

```
$ npm install
```
続けて以下のコマンドを実行。

``` 
$ npm run build
```

/src/main/resources 内のstaticディレクトリにcss,js,画像ファイルが生成され、templatesディレクトリにhtmlが生成されれば成功。

### ローカル環境にDBを構築
ローカル環境にPostgreSQLをインストールし、以下のデータベースとユーザーを作成する。

データベース名：sample-db

ユーザー名：sample-user

ユーザーパスワード：sample

### A5:SQL Mk-2でテーブルを作成
(A5:SQL Mk-2の細かい使い方は省略)

A5:SQL Mk-2で/document/ER図.a5er を開き、sample-dbにテーブルを追加

public.role_master.sql,public.user_master.sql,public.user_role_master.sqlのSQLを実行し、テストデータを追加

### Spring Bootでローカルサーバー起動
適当なJavaの開発環境(Eclipse等)を用意し、プロジェクトをビルドしてローカルサーバーを起動。
