package main.DAO;

public class UserSession {
    private static String currentUserType;
    private static String currentusername ;
    private static int currentuserid ;
    


    public static void setCurrentUserType(String userType , String username , int id) {
        currentUserType = userType;
        currentusername = username ;
        currentuserid = id ;
    }
    public static void setCurrentUsername( String username ){
        currentusername = username ;
    }
    public static void setcurrenttypeuser(String userType ){
        currentUserType = userType;
    }
    public static void setcurrentid(int id){
        currentuserid = id;
    }
    public static String getCurrentUserType() {
        return currentUserType;
    }
    public static String getCurrentUsername() {
        return currentusername;
    }
    public static int getCurrentUserid() {
        return currentuserid;
    }
    
}