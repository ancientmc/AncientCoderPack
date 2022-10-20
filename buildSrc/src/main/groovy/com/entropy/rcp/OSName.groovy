package com.entropy.rcp

import org.gradle.internal.os.OperatingSystem

class OSName {
    static String getOSName() {
        OperatingSystem os = OperatingSystem.current()
        if (os.isWindows()) {
            return "windows"
        } else if (os.isMacOsX()) {
            return "osx"
        } else if (os.isLinux()) {
            return "linux"
        }
        return "unknown"
    }
}
