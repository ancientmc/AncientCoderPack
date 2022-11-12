package com.entropy.rcp.tasks

import org.gradle.api.tasks.JavaExec
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

class RCPJavaExec extends JavaExec {
    public @OutputFile
    File dest

    File getDest() {
        return dest
    }

    @TaskAction
    void exec() {
        super.exec()
    }
}
