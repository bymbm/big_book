import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Service service = new Service();
        User currentUser = null;

        while (currentUser == null) {
            System.out.println("请选择操作：1.注册 2.登录 0.退出");
            int operation = scanner.nextInt();
            switch (operation) {
                case 1:
                    System.out.println("请输入用户名和密码：");
                    String username1 = scanner.next();
                    String password1 = scanner.next();
                    if(service.register(username1, password1)) {
                        System.out.println("注册成功");
                    } else {
                        System.out.println("注册失败，用户名可能已被使用");
                    }
                    break;
                case 2:
                    System.out.println("请输入用户名和密码：");
                    String username2 = scanner.next();
                    int tries = 0;
                    while (tries < 3) {
                        String password2 = scanner.next();
                        if(service.login(username2, password2)) {
                            System.out.println("登录成功");
                            currentUser = service.getUser(username2);  // Assuming getUser method is available in Service class
                            break;
                        } else {
                            System.out.println("密码错误，你还有 " + (2-tries) + " 次尝试机会");
                            tries++;
                        }
                    }
                    if (tries == 3) {
                        System.out.println("密码输入错误3次，退出系统");
                        return;
                    }
                    break;
                case 0:
                    System.out.println("退出系统");
                    return;
            }
        }

        // 登录成功后，进行图书的增删改查
        while (true) {
            System.out.println("请选择操作：1.查询所有数据 2.根据id查询 3.新增 4.修改 5.删除 0.退出");
            int operation = scanner.nextInt();
            switch (operation) {
                case 1:
                    System.out.println(service.getAllBooks());
                    break;
                case 2:
                    System.out.println("请输入书的id：");
                    int id2 = scanner.nextInt();
                    System.out.println(service.getBook(id2));
                    break;
                case 3:
                    System.out.println("请输入新书的名字和价格：");
                    String name3 = scanner.next();
                    double price3 = scanner.nextDouble();
                    System.out.println(service.addBook(name3, price3));
                    break;
                case 4:
                    System.out.println("请输入要修改的书的id、名字和价格：");
                    int id4 = scanner.nextInt();
                    String name4 = scanner.next();
                    double price4 = scanner.nextDouble();
                    if(service.updateBook(id4, name4, price4)) {
                        System.out.println("修改成功");
                    } else {
                        System.out.println("修改失败，书不存在");
                    }
                    break;
                case 5:
                    System.out.println("请输入要删除的书的id：");
                    int id5 = scanner.nextInt();
                    if(service.deleteBook(id5)) {
                        System.out.println("删除成功");
                    } else {
                        System.out.println("删除失败，书不存在");
                    }
                    break;
                case 0:
                    System.out.println("退出系统");
                    return;
            }
        }
    }
}
