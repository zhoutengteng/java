BASEDIR="/home/zhoutengteng/Desktop/java_test/allTestBash/"
ANTDIR="cal"
JUNIT="antstudyHello"
SONAR="sonar"
BUGRUNNER="BugRunner/Gridworld/GridWorldCode/"

echo "用ant编译并运行计算器 请输入开始yes"
read commad
while [ "$commad" != "yes" ]
do
   read commad

done

cd $BASEDIR
NUM1=`wc -l $ANTDIR/exe.txt | cut -d ' '  -f1`
COUNT=0
while [ $NUM1 != 0 ]
do
    COUNT=$((COUNT+1))
    cd $BASEDIR
    cd $ANTDIR
    `head  -n $COUNT exe.txt | tail -n1`
    cd $BASEDIR
    NUM1=$((NUM1-1))
done
echo "第一个测试完成\n"



echo "\n\n\n用JUNIT测试helloworld 请输入开始yes"
read commad
while [ "$commad" != "yes" ]
do
   read commad

done

cd $BASEDIR
NUM1=`wc -l $JUNIT/exe.txt | cut -d ' '  -f1`
COUNT=0
while [ $NUM1 != 0 ]
do
    COUNT=$((COUNT+1))
    cd $BASEDIR
    cd $JUNIT
    `head  -n $COUNT exe.txt | tail -n1`
    cd $BASEDIR
    NUM1=$((NUM1-1))
done
echo "第二个测试完成\n"




echo "\n\n\n用sonar测试cal 请输入开始yes"

read commad
while [ "$commad" != "yes" ]
do
   read commad

done

cd $BASEDIR
NUM1=`wc -l $SONAR/exe.txt | cut -d ' '  -f1`
COUNT=0
while [ $NUM1 != 0 ]
do
    COUNT=$((COUNT+1))
    cd $BASEDIR
    cd $SONAR
    `head  -n $COUNT exe.txt | tail -n1`
    cd $BASEDIR
    NUM1=$((NUM1-1))
done
echo "第三个测试完成\n"




echo "\n\n运行BugRunner 请输入开始yes"
read commad
while [ "$commad" != "yes" ]
do
   read commad

done

#cd $BASEDIR
#NUM1=`wc -l $BUGRUNNER/exe.txt | cut -d ' '  -f1`
#COUNT=0
#while [ $NUM1 != 0 ]
#do
#    COUNT=$((COUNT+1))
#    cd $BASEDIR
#    cd $BUGRUNNER
#    head  -n $COUNT exe.txt | tail -n1
#    
#    NUM1=$((NUM1-1))
#done

cd /home/zhoutengteng/Desktop/java_test/allTestBash/BugRunner/Gridworld/GridWorldCode
javac -classpath .:gridworld.jar /home/zhoutengteng/Desktop/java_test/allTestBash/BugRunner/Gridworld/GridWorldCode/projects/firstProject/BugRunner.java
cd /home/zhoutengteng/Desktop/java_test/allTestBash/BugRunner/Gridworld/GridWorldCode/projects/firstProject
java -classpath .:/home/zhoutengteng/Desktop/java_test/allTestBash/BugRunner/Gridworld/GridWorldCode/gridworld.jar BugRunner
echo "第四个测试完成\n"
