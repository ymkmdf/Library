package com.meipan.library.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.platform.Platform;

import static okhttp3.internal.platform.Platform.INFO;

/**
 * Created by gaoyan on 17/3/9.
 */

public class HttpLogger implements Interceptor {
    private static final String TAG = "HttpLogger";
    private static final Charset UTF8 = Charset.forName("UTF-8");

    public interface Logger {
        void log(String message);

        /**
         * A {@link Logger} defaults output appropriate for the current platform.
         */
        Logger DEFAULT = new Logger() {
            @Override
            public void log(String message) {
                Platform.get().log(INFO, message, null);
            }
        };
    }
    private final Logger logger;

    public HttpLogger() {
        this(Logger.DEFAULT);
    }

    public HttpLogger(Logger logger) {
        this.logger = logger;
    }
    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        //是否打印日志
        if (!true) {
            return chain.proceed(request);
        }
        Connection connection = chain.connection();
        Protocol protocol = connection != null ? connection.protocol() : Protocol.HTTP_1_1;
        String requestStartMessage = "--> " + request.method() + ' ' + request.url() + ' ' + protocol;
        logger.log("================== 请求URL ==================");
        logger.log(requestStartMessage);
        logger.log("================== 请求头 ==================");
        Headers headers = request.headers();
        for (int i = 0, count = headers.size(); i < count; i++) {
            String name = headers.name(i);
            logger.log(name + ": " + headers.value(i));
        }
        logger.log("================== 头结束 ==================");


        long startNs = System.nanoTime();
        Response response;
        try {
            response = chain.proceed(request);
        } catch (Exception e) {
            logger.log("<-- HTTP FAILED: " + e);
            throw e;
        }
        long tookMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNs);

        ResponseBody responseBody = response.body();
        logger.log("<-- " + response.code() + "  " + response.message() + "  " + response.request().url() + " (" + tookMs + "ms" +')');
        String body = responseBody.string();
        logger.log(body);
        //json 格式化
        com.meipan.library.utils.Logger.j(body);

        return chain.proceed(request);
    }




}
