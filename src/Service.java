import java.util.*;

public class Service {
    private Map<String, User> users = new HashMap<>();
    private Map<Integer, Book> books = new HashMap<>();
    private int bookIdCounter = 1;

    // 用户注册
    public boolean register(String username, String password) {
        if (username == null || password == null || users.containsKey(username)) {
            return false;
        }
        users.put(username, new User(username, password));
        return true;
    }

    // 用户登录
    public boolean login(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }

    // 根据用户名获取用户
    public User getUser(String username) {
        return users.get(username);
    }

    // 添加图书
    public Book addBook(String name, double price) {
        Book book = new Book(bookIdCounter++, name, price);
        books.put(book.getId(), book);
        return book;
    }

    // 查询图书
    public Book getBook(int id) {
        return books.get(id);
    }

    // 更新图书
    public boolean updateBook(int id, String name, double price) {
        Book book = books.get(id);
        if (book == null) {
            return false;
        }
        book.setName(name);
        book.setPrice(price);
        return true;
    }

    // 删除图书
    public boolean deleteBook(int id) {
        return books.remove(id) != null;
    }

    // 获取所有图书
    public Collection<Book> getAllBooks() {
        return books.values();
    }
}
