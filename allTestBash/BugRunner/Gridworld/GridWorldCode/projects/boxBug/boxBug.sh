GRIDCODE_JAR="/home/zhoutengteng/Desktop/java_test/allTestBash/BugRunner/Gridworld/GridWorldCode/"
BOXBUG_DIR="$GRIDCODE_JAR/projects/boxBug"
BOXBUG_JAVA="BoxBug.java"
BOXBUGRUNNER_JAVA="BoxBugRunner.java"
BOXBUGJUNNER_CLASS="BoxBugRunner"
cd $BOXBUG_DIR
ls
javac -classpath .:/home/zhoutengteng/Desktop/java_test/allTestBash/BugRunner/Gridworld/GridWorldCode/gridworld.jar BoxBug.java
#javac -classpath .:$GRIDCODE_JAR $BOXBUG_JAVA
javac -classpath .:/home/zhoutengteng/Desktop/java_test/allTestBash/BugRunner/Gridworld/GridWorldCode/gridworld.jar BoxBugRunner.java
##javac -classpath .:$GRIDCODE_JAR $BOXBUGRUNNER_JAVA

java -classpath .:/home/zhoutengteng/Desktop/java_test/allTestBash/BugRunner/Gridworld/GridWorldCode/gridworld.jar BoxBugRunner
#java   -classpath .:$GRIDCODE_JAR $BOXBUGJUNNER_CLASS

