import java.io.File;
import java.util.Scanner;

public class 批量删除
{
    static int countFile=0;//文件计数
    static int countDirectory=0;//文件夹计数

    public static void main(String[] args)
    {
        //delete方法 只能删除文件和空文件夹.
        //如果现在要删除一个有内容的文件夹,先删掉这个文件夹里面所有的内容,最后再删除这个文件夹

        Scanner sc=new Scanner(System.in);

        System.out.print("请输入要搜索的路径：");
        String road=sc.nextLine();

        System.out.print("是否包含子目录（0不包含、1包含）：");
        String choice1=sc.nextLine();
        while(!(choice1.equals("1")||choice1.equals("0")))
        {
            System.out.println("输入有误，请重新输入");
            System.out.print("是否包含子目录（0不包含、1包含）：");
            choice1=sc.nextLine();
        }

        System.out.print("删除文件or文件夹（1文件、2文件夹、3文件和文件夹）(选择3会忽略文件后缀)：");
        String choice2=sc.nextLine();
        while(!(choice2.equals("1")||choice2.equals("2")||choice2.equals("3")))
        {
            System.out.println("输入有误，请重新输入");
            System.out.print("删除文件or文件夹（1文件、2文件夹、3文件和文件夹）(选择3会忽略文件后缀)：");
            choice2=sc.nextLine();
        }

        String choice3="0";
        if(choice2.equals("2")||choice2.equals("3"))
        {
            System.out.print("若文件夹不为空是否删除（1是、0否）：");
            choice3=sc.nextLine();
            while(!(choice3.equals("1")||choice3.equals("0")))
            {
                System.out.println("输入有误，请重新输入");
                System.out.print("若文件夹不为空是否删除（1是、0否）：");
                choice3=sc.nextLine();
            }
        }

        System.out.print("请输入要被删除的文件（夹）全名：");
        String name=sc.nextLine();

        System.out.println(" ");
        File src=new File(road);
        bianli(src,choice1,choice2,choice3,name);

        System.out.println("共计删除文件:"+countFile);
        System.out.println("共计删除文件夹:"+countDirectory);
        System.out.println("共计删除:"+(countFile+countDirectory));
        System.out.println("按任意键+回车退出...");
        String t=sc.nextLine();
    }


    private static void bianli(File src,String choice1,String choice2,String choice3,String name)
    {
        //递归 方法在方法体中自己调用自己.

        //遍历这个File对象,获取它下边的每个文件和文件夹对象
        File[] files=src.listFiles();

        if(files!=null)
        {
            for(File file : files)
            {
                String fileName=file.getName();
                //choice3文件夹和文件都删除，则会忽略文件的后缀
                if(file.isFile()&&choice2.equals("3"))
                {
                    int i=fileName.lastIndexOf(".");
                    fileName=file.getName().substring(0,i);
                }

                //文件和文件夹
                if(fileName.equals(name))
                {
                    //只删除文件
                    if(choice2.equals("1")&&file.isFile())
                    {
                        deleteDir(file,choice3,name);
                    }
                    //只删除文件夹
                    else if(choice2.equals("2")&&file.isDirectory())
                    {
                        deleteDir(file,choice3,name);
                    }
                    //删除文件和文件夹
                    else if(choice2.equals("3"))
                    {
                        deleteDir(file,choice3,name);
                    }
                }
                else if(choice1.equals("1"))
                {
                    //递归调用自己,将当前遍历到的File对象当做参数传递
                    bianli(file,choice1,choice2,choice3,name);//参数一定要是src文件夹里面的文件夹File对象
                }
            }
        }
    }

    //删除
    private static void deleteDir(File src,String choice3,String delName)
    {
        //先删掉这个文件夹里面所有的内容.
        //递归 方法在方法体中自己调用自己.

        //是文件直接删除
        if(src.isFile())
        {
            System.out.println("删除文件："+src.getPath());
            src.delete();
            countFile++;
        }
        else
        {
            File[] files=src.listFiles();
            int length=files.length;

            //文件不为空也删除
            if(choice3.equals("1"))
            {
                for(File file : files)
                {
                    //如果是文件,直接删除
                    if(file.isFile())
                    {
                        file.delete();
                    }
                    else
                    {
                        //如果是文件夹,递归调用自己,将当前遍历到的File对象当做参数传递
                        deleteDir(file,choice3,delName);//参数一定要是src文件夹里面的文件夹File对象
                    }
                }
                //参数传递过来的文件夹File对象已经处理完成,最后直接删除这个空文件夹
                if(src.getName().equals(delName))
                {
                    System.out.println("删除文件夹："+src.getPath());
                    countDirectory++;
                }
                src.delete();
            }
            //文件不为空则不删除
            else
            {
                //文件夹不为空
                if(length>0)
                {
                }
                //文件夹为空
                else
                {
                    System.out.println("删除文件："+src.getPath());
                    src.delete();
                    countDirectory++;
                }
            }

        }
    }
}