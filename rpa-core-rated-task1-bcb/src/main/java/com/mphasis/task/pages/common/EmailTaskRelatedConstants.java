package com.mphasis.task.pages.common;

public class EmailTaskRelatedConstants {

    // EmailClientBotTask

    public static final String DEFAULT_SMTP_HOST = "najlepszy.home.pl";

    public static final String DEFAULT_SMTP_PORT = "587";

    public static final String DEFAULT_SENDER_EMAIL = "sniezko@najlepszy.email";

    public static final String DEFAULT_SENDER_LOGIN = "sniezko.najlepszy";

    public static final String DEFAULT_SENDER_PASSWORD = "lbp4CQP4ANk92GYt";

    public static final String DEFAULT_RECIPIENT_EMAIL = "tuk.tuk.rpa@gmail.com";

    public static final String TEST_EMAIL_RECIPIENT = "eugenioskye@gmail.com";

    public static final String DEFAULT_SUBJECT = "RPA Core Task 1 - Email Task Bot Task execution result";

    public static final String DEFAULT_MESSAGE = "Hello World";

    private EmailTaskRelatedConstants() {
        throw new IllegalStateException("Utility class should not be instantiated!");
    }

}
