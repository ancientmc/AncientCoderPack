/**
 * This class uses the Gradle API to return the name of the end-users' OS in a string form.
 * This string gets used by the main gradle for several tasks.
 */

package com.entropy.rcp.utils

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
