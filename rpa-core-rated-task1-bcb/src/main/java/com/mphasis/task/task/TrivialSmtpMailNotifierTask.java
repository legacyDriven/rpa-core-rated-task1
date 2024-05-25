package com.mphasis.task.task;

import com.mphasis.task.pages.client.TrivialSmtpClient;
import com.mphasis.task.pages.dto.EmailClientConfigDto;
import com.mphasis.task.pages.dto.EmailMessageDto;
import com.workfusion.odf2.core.task.AdHocTask;
import com.workfusion.odf2.core.task.TaskInput;
import com.workfusion.odf2.core.task.output.TaskRunnerOutput;

import static com.mphasis.task.pages.common.EmailTaskRelatedConstants.*;

public class TrivialSmtpMailNotifierTask implements AdHocTask {


    @Override
    public TaskRunnerOutput run(TaskInput taskInput) {
        // Konfiguracja klienta email
        EmailClientConfigDto emailConfig = EmailClientConfigDto.builder()
                .host(DEFAULT_SMTP_HOST)
                .username(DEFAULT_SENDER_LOGIN)
                .password(DEFAULT_SENDER_PASSWORD)
                .port(Integer.parseInt(DEFAULT_SMTP_PORT))
                .build();

        // Treść wiadomości email
        EmailMessageDto emailMessage = EmailMessageDto.builder()
                .recipient(TEST_EMAIL_RECIPIENT)
                .body(DEFAULT_MESSAGE)
                .build();

        // Utworzenie i wysłanie emaila
        TrivialSmtpClient smtpClient = new TrivialSmtpClient(emailConfig);
        smtpClient.sendEmail(emailMessage);

        // Zwracanie wyniku
//        return SingleResult.of("status", "Email sent successfully");
        return taskInput.asResult()
                .withColumn("status", "Email sent successfully");
    }
}
