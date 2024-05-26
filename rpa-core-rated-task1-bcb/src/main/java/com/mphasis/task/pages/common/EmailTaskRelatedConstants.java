package com.mphasis.task.pages.common;

public class EmailTaskRelatedConstants {

    // EmailClientBotTask

    public static final String DEFAULT_SMTP_HOST = "live.smtp.mailtrap.io";

    public static final String DEFAULT_SMTP_PORT = "587";

    public static final String DEFAULT_SENDER_EMAIL = "mailtrap@demomailtrap.com";
    public static final String DEFAULT_SENDER_LOGIN = "api"; // Twój adres e-mail na WP.pl

    public static final String DEFAULT_SENDER_PASSWORD = "805953f5942c840634f6cb1888ae7ea5";

    public static final String DEFAULT_RECIPIENT_EMAIL = "tuk.tuk.rpa@gmail.com";

    public static final String TEST_EMAIL_RECIPIENT = "eugenioskye@gmail.com";

    public static final String DEFAULT_MESSAGE = "Hello World";

    private EmailTaskRelatedConstants() {
        throw new IllegalStateException("Utility class should not be instantiated!");
    }

}
