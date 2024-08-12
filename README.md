# koverVerifyJvm issue
This project was created as a minimal setup to reproduce the issue I will describe below

## Description

This is a KMP project which has Android, iOS and Desktop as targets. Im using Kotlin test as test library and kover as coverage checker tool

When we run the command `koverVerify` without specifying any target, the coverage check runs flawlessly

```sh
❯ ./gradlew koverVerify    
Type-safe project accessors is an incubating feature.
> Task :koverVerify FAILED

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':koverVerify'.
> Rule violated:
    lines covered percentage is 0.000000, but expected minimum is 100
    instructions covered percentage is 0.000000, but expected minimum is 100


* Try:
> Run with --stacktrace option to get the stack trace.
> Run with --info or --debug option to get more log output.
> Run with --scan to get full insights.
> Get more help at https://help.gradle.org.

Deprecated Gradle features were used in this build, making it incompatible with Gradle 9.0.

You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.

For more on this, please refer to https://docs.gradle.org/8.7/userguide/command_line_interface.html#sec:command_line_warnings in the Gradle documentation.

BUILD FAILED in 825ms
64 actionable tasks: 1 executed, 63 up-to-date

```

However, when running `koverVerifyJvm` which should run the checks for JVM targets, the check does not happen and the task is "success" every time:

```shell
❯ ./gradlew koverVerifyJvm
Type-safe project accessors is an incubating feature.

Deprecated Gradle features were used in this build, making it incompatible with Gradle 9.0.

You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.

For more on this, please refer to https://docs.gradle.org/8.7/userguide/command_line_interface.html#sec:command_line_warnings in the Gradle documentation.

BUILD SUCCESSFUL in 609ms
13 actionable tasks: 1 executed, 12 up-to-date
```

When running `:koverVerifyJvm` it says the task does not exist
```shell
❯ ./gradlew :koverVerifyJvm
Type-safe project accessors is an incubating feature.

FAILURE: Build failed with an exception.

* What went wrong:
Cannot locate tasks that match ':koverVerifyJvm' as task 'koverVerifyJvm' not found in root project 'KMP'. Some candidates are: 'koverVerify'.

* Try:
> Run gradlew tasks to get a list of available tasks.
> For more on name expansion, please refer to https://docs.gradle.org/8.7/userguide/command_line_interface.html#sec:name_abbreviation in the Gradle documentation.
> Run with --stacktrace option to get the stack trace.
> Run with --info or --debug option to get more log output.
> Run with --scan to get full insights.
> Get more help at https://help.gradle.org.

Deprecated Gradle features were used in this build, making it incompatible with Gradle 9.0.

You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.

For more on this, please refer to https://docs.gradle.org/8.7/userguide/command_line_interface.html#sec:command_line_warnings in the Gradle documentation.

BUILD FAILED in 499ms

```