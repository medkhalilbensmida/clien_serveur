import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class TaskListImpl extends UnicastRemoteObject implements TaskList {
    
    private List<String> tasks = new ArrayList<>();

    public TaskListImpl() throws RemoteException {
        super();
    }

    @Override
    public void addTask(String task) throws RemoteException {
        tasks.add(task);
    }

    @Override
    public void removeTask(String task) throws RemoteException {
        tasks.remove(task);
    }

    @Override
    public List<String> getTasks() throws RemoteException {
        return tasks;
    }
}