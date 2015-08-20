GRIDCODE_JAR="/home/zhoutengteng/Desktop/java_test/allTestBash/BugRunner/Gridworld/GridWorldCode/"
BOXBUG_DIR="$GRIDCODE_JAR/projects/zBug"
BOXBUG_JAVA="ZBug.java"
BOXBUGRUNNER_JAVA="ZBugRunner.java"
BOXBUGJUNNER_CLASS="ZBugRunner"
cd $BOXBUG_DIR
ls
javac -classpath .:/home/zhoutengteng/Desktop/java_test/allTestBash/BugRunner/Gridworld/GridWorldCode/gridworld.jar $BOXBUG_JAVA
#javac -classpath .:$GRIDCODE_JAR $BOXBUG_JAVA
javac -classpath .:/home/zhoutengteng/Desktop/java_test/allTestBash/BugRunner/Gridworld/GridWorldCode/gridworld.jar $BOXBUGRUNNER_JAVA
##javac -classpath .:$GRIDCODE_JAR $BOXBUGRUNNER_JAVA

java -classpath .:/home/zhoutengteng/Desktop/java_test/allTestBash/BugRunner/Gridworld/GridWorldCode/gridworld.jar $BOXBUGJUNNER_CLASS
#java   -classpath .:$GRIDCODE_JAR $BOXBUGJUNNER_CLASS

