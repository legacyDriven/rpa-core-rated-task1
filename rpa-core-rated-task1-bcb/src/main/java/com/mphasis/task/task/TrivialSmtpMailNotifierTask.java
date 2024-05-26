package com.mphasis.task.task;

import com.mphasis.task.pages.client.TrivialSmtpMailClient;
import com.workfusion.odf2.compiler.BotTask;
import com.workfusion.odf2.core.task.AdHocTask;
import com.workfusion.odf2.core.task.TaskInput;
import com.workfusion.odf2.core.task.output.TaskRunnerOutput;

@BotTask(requireRpa = false)
public class TrivialSmtpMailNotifierTask implements AdHocTask {


    @Override
    public TaskRunnerOutput run(TaskInput taskInput) {
        TrivialSmtpMailClient sender = new TrivialSmtpMailClient();
        sender.sendEmail();
        return taskInput.asResult()
                .withColumn("status", "Email sent successfully");
    }
}
