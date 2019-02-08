import java.util.List;

public class ListOfTasks {

    List<String> list;

    public ListOfTasks(){

    }
    public ListOfTasks(List<String> list){

        this.list = list;
    }

    public void add(String task){

        list.add(task);
    }
    public int size(){
        return list.size();
    }

    public String get(int i){

        String task = list.get(i);
        return task;

    }

    public void printSreen(){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }


}
