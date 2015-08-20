GRIDCODE_JAR="/home/zhoutengteng/Desktop/java_test/allTestBash/BugRunner/Gridworld/GridWorldCode/"
BOXBUG_DIR="$GRIDCODE_JAR/projects/spiralBug"
BOXBUG_JAVA="SpiralBug.java"
BOXBUGRUNNER_JAVA="SpiralBugRunner.java"
BOXBUGJUNNER_CLASS="SpiralBugRunner"
cd $BOXBUG_DIR
ls
javac -classpath .:/home/zhoutengteng/Desktop/java_test/allTestBash/BugRunner/Gridworld/GridWorldCode/gridworld.jar SpiralBug.java
#javac -classpath .:$GRIDCODE_JAR $BOXBUG_JAVA
javac -classpath .:/home/zhoutengteng/Desktop/java_test/allTestBash/BugRunner/Gridworld/GridWorldCode/gridworld.jar SpiralBugRunner.java
##javac -classpath .:$GRIDCODE_JAR $BOXBUGRUNNER_JAVA

java -classpath .:/home/zhoutengteng/Desktop/java_test/allTestBash/BugRunner/Gridworld/GridWorldCode/gridworld.jar SpiralBugRunner
#java   -classpath .:$GRIDCODE_JAR $BOXBUGJUNNER_CLASS

