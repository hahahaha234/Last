大181   马海   2018310986
实验五  综合性实验  学生选课系统设计
实验目的
    分析学生选课系统
    使用GUI窗体及其组件设计窗体界面
    完成学生选课过程业务逻辑编程
    基于文件保存并读取数据
    处理异常
实验要求
    一、系统角色分析及类设计
        例如：学校有“人员”，分为“教师”和“学生”，教师教授“课程”，学生选择课程。
        定义每种角色人员的属性，及其操作方法。
        属性示例：	人员（编号、姓名、性别……）
        教师（编号、姓名、性别、所授课程、……）
              学生（编号、姓名、性别、所选课程、……）
              课程（编号、课程名称、上课地点、时间、授课教师、……）
        以上属性仅为示例，同学们可以自行扩展。

    二、要求:
        1、	设计GUI窗体，支持学生注册、课程新加、学生选课、学生退课、打印学生选课列表等操作。
        2、	基于事件模型对业务逻辑编程，实现在界面上支持上述操作。
        3、	针对操作过程中可能会出现的各种异常，做异常处理
        4、	基于输入/输出编程，支持学生、课程、教师等数据的读写操作。
        5、	基于Github.com提交实验，包括实验SRC源文件夹程序、README.MD实验报告文档。
  
调试过程
    先建立学生管理包和登录信息采集包，在登录信息采集包中，建立FileOpe类，在bin/Last文件下建立一个txt文件来存储注册登录信息，
否则将会抛出文件异常。建立登录页面，在页面中设置登录注册按钮，用户要先进行注册，将信息存储到文件里。在登录界面，
String account=tfAccount.getText();String password=new String(pfPassword.getPassword());FileOpe.getInfoByAccount(account);
来获取已经储存了的用户信息。如果密码或用户名不一致则无法进行登录。在管理系统中，分别建立两个类来描述学生和教师信息。在教师信息界面
中，设置编号，姓名，年龄，所教课程等变量；在学生信息界面中，设置学号，姓名，年龄，所选课程等变量。分别建立教师和学生数组，将信息分别
存储在两个文件夹之中。在显示打印结果的时候，将文件中的信息打印出来。
核心代码
 public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btLogin) {
            String account=tfAccount.getText();
            String password=new String(pfPassword.getPassword());
            FileOpe.getInfoByAccount(account);
            if(Conf.account==null||!Conf.password.equals(password)) {
                JOptionPane.showMessageDialog(this,"登录失败");
                return;
            }
            JOptionPane.showMessageDialog(this,"登录成功");
            this.dispose();
            new Login();
        }

