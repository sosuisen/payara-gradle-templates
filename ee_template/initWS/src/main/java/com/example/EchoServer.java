package com.example;

import java.io.IOException;
import java.util.logging.Level;

import jakarta.websocket.CloseReason;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.java.Log;

@Log
@ServerEndpoint("/echo")
public class EchoServer {
	// クライアントから接続されたとき
	@OnOpen
	public void onOpen(Session session) {
		// session はこのクライアントとサーバのセッション
		try {
			// セッションから接続先のクライアントを取得してテキスト送信
			session.getBasicRemote().sendText("[Welcome! from EchoServer]");
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.log(Level.INFO, "onOpen");
	}

	// クライアントからメッセージを受信したとき
	@OnMessage
	public void onMessage(String mes, Session session) {
		try {
			session.getBasicRemote().sendText(mes);
		} catch (IOException e) {
			e.printStackTrace();
		}

		log.log(Level.INFO, "onMessage");
	}
	
	// エラーが発生したとき
    @OnError
    public void onError(Session session, Throwable e) {
    	log.log(Level.SEVERE, "onError: " + e.toString(), e);
    }

	// WebSocketが閉じたとき
	@OnClose
	public void onClose(Session session, CloseReason reason) {
		// 閉じた理由をコンソールへ表示
		log.log(Level.INFO, "onClose: " + reason.toString());
	}
}
