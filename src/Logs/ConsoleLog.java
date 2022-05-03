package Logs;

public class ConsoleLog {
    public static void log(int ID, String text){
        System.out.println("ID [" + ID + "] " + text);
    }

    public static void log(int ID, String text, int time){
        System.out.println("ID [" + ID + "] " + text + time + " sec");
    }

    public static void log(String text){
        System.out.println("INTERFACE " + text);
    }
}
