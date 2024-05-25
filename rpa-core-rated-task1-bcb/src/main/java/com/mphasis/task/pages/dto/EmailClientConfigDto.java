package com.mphasis.task.pages.dto;

public class EmailClientConfigDto {

    private final String host;

    private final String username;

    private final String password;

    private final int port;

    public EmailClientConfigDto(String host, String username, String password, int port) {
        this.host = host;
        this.username = username;
        this.password = password;
        this.port = port;
    }

    public static EmailClientConfigDtoBuilder builder() {
        return new EmailClientConfigDtoBuilder();
    }

    public String getHost() {
        return this.host;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public int getPort() {
        return this.port;
    }

    public static class EmailClientConfigDtoBuilder {
        private String host;
        private String username;
        private String password;
        private int port;

        EmailClientConfigDtoBuilder() {
        }

        public EmailClientConfigDtoBuilder host(String host) {
            this.host = host;
            return this;
        }

        public EmailClientConfigDtoBuilder username(String username) {
            this.username = username;
            return this;
        }

        public EmailClientConfigDtoBuilder password(String password) {
            this.password = password;
            return this;
        }

        public EmailClientConfigDtoBuilder port(int port) {
            this.port = port;
            return this;
        }

        public EmailClientConfigDto build() {
            return new EmailClientConfigDto(this.host, this.username, this.password, this.port);
        }

        public String toString() {
            return "EmailClientConfigDto.EmailClientConfigDtoBuilder(host=" + this.host + ", username=" + this.username + ", password=" + this.password + ", port=" + this.port + ")";
        }
    }
}
