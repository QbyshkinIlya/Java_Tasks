package com.example.task8a;

public class TaskFabrica {
    public static String H2 = "H2";

    public static String PG = "PG";
    private TaskDAO FabDAO = null;

    public TaskDAO getFabDAO(String shapeType){
        if (shapeType.equalsIgnoreCase(H2)){
            FabDAO = new TaskDAOImpl();
        }else if (shapeType.equalsIgnoreCase(PG)) {
            FabDAO = new FileTaskDAO("src/main/resources/com/example/task8a/tasks.txt");//имя файла
        }
        return FabDAO;
    }


}