
 public class AdminDao implements Admin {
     
     public static AdminDao adminDao = null;
     private AdminDao() {
         System.out.println("a");
     }
     
     public static AdminDao getInstance() {
         if(adminDao == null ) {
            adminDao = new AdminDao();
            return adminDao;
         }else {
             return adminDao;
         }
     }
}
