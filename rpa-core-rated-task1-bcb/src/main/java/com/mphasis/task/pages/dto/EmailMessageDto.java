package com.mphasis.task.pages.dto;

public class EmailMessageDto {

    private final String recipient;

    private final String body;

    public EmailMessageDto(String recipient, String body) {
        this.recipient = recipient;
        this.body = body;
    }

    public static EmailMessageDtoBuilder builder() {
        return new EmailMessageDtoBuilder();
    }

    public String getRecipient() {
        return this.recipient;
    }

    public String getBody() {
        return this.body;
    }

    public static class EmailMessageDtoBuilder {
        private String recipient;
        private String body;

        EmailMessageDtoBuilder() {
        }

        public EmailMessageDtoBuilder recipient(String recipient) {
            this.recipient = recipient;
            return this;
        }

        public EmailMessageDtoBuilder body(String body) {
            this.body = body;
            return this;
        }

        public EmailMessageDto build() {
            return new EmailMessageDto(this.recipient, this.body);
        }

        public String toString() {
            return "EmailMessageDto.EmailMessageDtoBuilder(recipient=" + this.recipient + ", body=" + this.body + ")";
        }
    }
}
