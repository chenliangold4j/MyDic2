package self.liang.maven.example;

/**
 * maven编译：mvn clean compile
 *         clean清除target目录   compile编译到target目录
 *
 * maven测试mvn clean test
 *      maven实际执行的不止clean和test，
 *      包括  clean：clean  resources:resources compiler:compile resources:testResources以及 compiler: testCompile
 *      maven执行前还会执行 主资源处理，主代码编译，测试代码编译等工作
 *
 *      maven是个项目管理工具，如果我们不告诉它我们的代码要使用什么样的jdk版本编译的话，
 *      它就会用maven-compiler-plugin默认的jdk版本来进行处理，这样就容易出现版本不匹配，
 *      以至于可能导致编译不通过的问题。
 *
 *maven打包和运行:mvn clean package
 *     会在target下生成jar或者war包
 *
 *maven安装：mvn install
 *      [INFO] Installing C:\Users\phantom\IdeaProjects\MyDic2\target\MyDic2-1.0-SNAPSHOT.war to C:\Users\phantom\.m2\repository\self\liang\MyDic2\1.0-SNAPSHOT\MyDic2-1.0-SNAPSHOT.war
 *      [INFO] Installing C:\Users\phantom\IdeaProjects\MyDic2\pom.xml to C:\Users\phantom\.m2\repository\self\liang\MyDic2\1.0-SNAPSHOT\MyDic2-1.0-SNAPSHOT.pom
 *      将项目输出的war或者jar安装到了本地仓库
 *
 *maven生成可执行jar
 *      需要借助maven-shade-pluginZ(?)将main方法信息添加到manifest中（META-INF/MANIFEST.MF）
 *
 *     artifact:n. 人工制品，手工艺品；非自然存在物体
 *maven坐标：groupId,artifactId,version时必须的
 *           scope，依赖范围，有：compile ,test,provided runtime,system  反正不明白就默认
 *           optional，是否可选，true为可选依赖（最好别用）
 *           exclusions：排除传递性依赖 mvn在传递冲突的时候。优先选路径最近的。路径相同谁先用谁
 *      平常用。。一般就指定版本呢，，然后排除一下依赖，scope都不一定指定
 *
 * maven生命周期：clean,default(构建项目) site（建立站点）
 *
 *
 * maven：聚合
 *   <modelVersion>4.0.0</modelVersion>
 *   <groupId>self.liang</groupId>
 *   <artifactId>MyDic2</artifactId>
 *   <version>1.0-SNAPSHOT</version>
 *     <modules>
 *         <module>testson</module>
 *         <module>testson2</module>
 *         <module>testparent</module>
 *     </modules>
 *     <packaging>pom</packaging>
 *     这样就聚合两个子模块
 *
 * maven：继承
 *          1.可以统一管理各个模块的依赖版本
 *
 *    安照的步骤：
 *    1.声明三个模块 parent son1 son2
 *    2.myDic2将三个模块聚合。son1,son2继承parent
 *    3.parent的packing也时pom
 *    4.son的配置
 *   <parent>
 *     <groupId>self.liang</groupId>
 *     <artifactId>testparent</artifactId>
 *     <version>1.0-SNAPSHOT</version>
 *     <relativePath>../testparent/pom.xml</relativePath>  应该指定父模块pom路径
 *   </parent>
 *   <artifactId>testson</artifactId> 这里去掉了groupId和version
 *
 *  这样就能继承依赖。。这时候去掉junit的；依赖。。子模块还是可以用到jUnit和guava
 *  dependencyManagement之后。。子模块就要声明依赖但是不用声明版本
 *
 *  聚合和继承时两个概念。。前者用于快速构建  后者用于消除重复的依赖
 *
 *
 * 环境隔离
 *      （1）、在pom文件中添加resources结点
 *              <resources>
 *       <resource>
 *         <directory>src/main/resources.${deploy.type}</directory>
 *         <excludes>
 *           <exclude>*.jsp</exclude>
 *         </excludes>
 *       </resource>
 *
 *       <resource>
 *         <directory>src/main/resources</directory>
 *       </resource>
 *     (2) 在pom文件中添加profiles结点
 *     <profiles>
 *     <profile>
 *       <id>dev</id>
 *       <activation>
 *         <activeByDefault>true</activeByDefault>
 *       </activation>
 *       <properties>
 *         <deploy.type>dev</deploy.type>
 *       </properties>
 *     </profile>
 *     <profile>
 *       <id>beta</id>
 *       <properties>
 *         <deploy.type>beta</deploy.type>
 *       </properties>
 *     </profile>
 *     <profile>
 *       <id>prod</id>
 *       <properties>
 *         <deploy.type>prod</deploy.type>
 *       </properties>
 *     </profile>
 *   </profiles>
 *
 *   (3) Maven环境隔离目录初始化
 *     之前我们在pom中配置了环境隔离的目录，resources下，
 *     那么就下来就是将需要进行隔离的文件单独放到一个文件夹中，
 *     公共的文件留在resources目录下即可。
 *
 *   (4)Maven环境隔离的使用
 *      idea右侧有maven的profiles选项
 *
 *      mvn clean package -Dmanven.test.skip=true -Pxxx
 *     这个命令的前面是一样的，只不过是多了一个参数-Pxxx，其中xxx表示你想编译的环境，-P表示的是使用Maven编译指令，
 *
 */
public class HelloMaven {

    public String sayHello(){
        return "Hello maven";
    }

    public static void main(String[] args) {
        HelloMaven helloMaven = new HelloMaven();
        System.out.println(helloMaven.sayHello());
    }

}
