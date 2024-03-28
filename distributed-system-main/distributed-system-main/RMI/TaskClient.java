import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class TaskListClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            TaskList taskList = (TaskList) registry.lookup("TaskList");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrez le nombre de tâches à ajouter : ");
            int numTasks = scanner.nextInt();
            scanner.nextLine(); 
            for (int i = 0; i < numTasks; i++) {
                System.out.print("Entrez le nom de la tâche " + (i + 1) + " : ");
                String taskName = scanner.nextLine();
                taskList.addTask(taskName);
            }

            List<String> tasks = taskList.getTasks();
            System.out.println("Liste des tâches :");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }

            System.out.print("Entrez le numéro de la tâche à supprimer : ");
            int taskIndex = scanner.nextInt();
            scanner.nextLine(); 
            if (taskIndex >= 1 && taskIndex <= tasks.size()) {
                String taskToRemove = tasks.get(taskIndex - 1);
                taskList.removeTask(taskToRemove);
                System.out.println("Tâche supprimée : " + taskToRemove);
            } else {
                System.out.println("Numéro de tâche invalide.");
            }

            tasks = taskList.getTasks();
            System.out.println("Liste des tâches après suppression :");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }

            scanner.close();
        } catch (Exception e) {
            System.err.println("TaskList client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}