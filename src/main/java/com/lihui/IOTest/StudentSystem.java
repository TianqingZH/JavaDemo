package com.lihui.IOTest;



import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentSystem {
    BufferedReader br;
    BufferedWriter bw;
    Scanner scanner ;
    String fileName ;

    public StudentSystem(Scanner scanner, String fileName) {
        this.scanner = scanner;
        this.fileName = fileName;
    }

    public static void main(String[] args) throws Exception {
        String fileName = "students.txt";
        StudentSystem studentSystem = new StudentSystem(
                new Scanner(System.in),
                fileName);
        studentSystem.startSystem();
    }
    public void startSystem() throws Exception {
        boolean flag = true;
            while(flag){
                Menu.showMenu();
                System.out.println("请输入要选择的操作：");
                String next = scanner.next();
                System.out.println(next);
                switch (Integer.parseInt(next)){
                    case 1:
                        addStudentInfo();
                        break;
                    case 2:
                        findStudentInfo();
                        break;
                    case 3:
                        findAllStudentInfo();
                        break;
                    case 4:
                        deleteStudentInfo();
                        break;
                    case 5:
                        exitSytem();
                        break;


                }

            }





    }

    private void exitSytem() {
    }

    private void deleteStudentInfo() throws IOException {
        List<String> list = new ArrayList<String>();
        br = new BufferedReader(new FileReader(fileName));
        System.out.println("请输入你要删除的学号：");
        String s = scanner.next();
        String msg;
        int len = 0;
        while ((msg = br.readLine())!=null){
            if (!msg.split(",")[0].equalsIgnoreCase(s))
            {
                list.add(msg);
                len++;
            }

        }
        if (len != 0){
            for (String s1:list) {
                bw = new BufferedWriter(new FileWriter(fileName));
                bw.write(s1);
                bw.newLine();
                bw.flush();
            }
        }else
            System.out.println("学号不存在，请检查输入！");
        br.close();

    }

    private void findAllStudentInfo() throws IOException {
        br = new BufferedReader(new FileReader(fileName));
        String temp = null;
        while((temp = br.readLine())!=null){
            String[] strarr = temp.split(",");
            System.out.println("学号："+strarr[0] + "姓名：" +strarr[1] +"性别：" + strarr[2] +"成绩：" + strarr[3]);
        }
    }

    private void findStudentInfo() throws IOException {
        br = new BufferedReader(new FileReader(fileName));
        System.out.println("请输入你要查找的学号：");
        String findInfo = scanner.next();
        String s;
        int temp=0;
        while((s = br.readLine())!= null){
            String[] str = s.split(",");
            if (findInfo.equalsIgnoreCase(str[0])) {
                temp++;
                System.out.println("学号："+str[0] + " 姓名：" + str[1] +" 性别：" + str[2]+"成绩：" + str[3]);
            }
        }
        if (temp == 0 )
            System.out.println("没有该学生信息！");
        br.close();

    }

    private void addStudentInfo() throws Exception {
        bw = new BufferedWriter(new FileWriter(fileName));
        boolean flag = true;
        while(flag) {
            System.out.println("请输入学号：");
            String sid = scanner.next();
            System.out.println("请输入名字：");
            String name = scanner.next();
            System.out.println("请输入性别：");
            String sex = scanner.next();
            System.out.println("请输入成绩：");
            String grade = scanner.next();
            bw.write(sid + "," + name +"," +grade + "," + sex + "," + grade);
            bw.flush();
            bw.newLine();
            System.out.println("是否继续添加学生信息，是输入1，否输入2");
            int temp = scanner.nextInt();
            if (temp == 2)
                flag = false;
        }
        bw.close();

    }


}
