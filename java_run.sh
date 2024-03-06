#!/bin/bash

options=(
    "-v --thread 2 --time 2 --step 1"
    "-v --thread 8 --time 5 --step 5"
    "-v --thread 16 --time 10 --step 10"
    "-v --thread 32 --time 20 --step 50"
)

base_command() {
    /home/karlenko/.jdks/openjdk-21.0.1/bin/java -javaagent:/snap/intellij-idea-ultimate/478/lib/idea_rt.jar=36585:/snap/intellij-idea-ultimate/478/bin -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /home/karlenko/IdeaProjects/lab1/out/production/lab1:/home/karlenko/.m2/repository/com/anaptecs/jeaf/owalibs/org.apache.commons.cli/4.3.1/org.apache.commons.cli-4.3.1.jar Main "$@"
}

print_verbose_results() {
    for i in "${options[@]}"; 
    do
        time base_command ${i}
        echo "==================================="
    done
}

print_verbose_results