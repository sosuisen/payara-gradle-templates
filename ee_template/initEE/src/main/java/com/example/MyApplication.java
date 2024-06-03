package com.example;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

/**
 * このアプリを設定するために必須のクラスです。
 * Jakarta MVCは、JAX-RSというAPIの上に作られているため、
 * JAX-RSのクラス Application を継承したクラスを宣言する必要があります。
 * 
 * @ApplicationPath は、このアプリが呼ばれるURLを指定するパスで、
 * コンテキストルート（通常はプロジェクト名）からの相対パスを書きます。
 * "/msg"を指定した場合のURLの例） http://localhost:8080/プロジェクト名/msg
 * 
 * パスの先頭の/と末尾の/はあってもなくても同じです。
 */
@ApplicationPath("/msg")
public class MyApplication extends Application {
}
