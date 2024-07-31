package Week_1_Exercises.DSA;

import java.util.*;

class Task {
    int taskId;
    String taskName, status;

    Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }
}

public class TaskManagementSystem {
    LinkedList<Task> tasks = new LinkedList<>();

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Task has been added successfully!");
    }

    public void searchTask(Task taskToBeSearched) {
        for (Task task : tasks) {
            if (task == taskToBeSearched) {
                System.out.println("Task has been found!");
                return;
            }
        }
        System.out.println("Task is not found!");
    }

    public void traverseTask() {
        Iterator<Task> traverse = tasks.iterator();
        while (traverse.hasNext()) {
            Task task = traverse.next();
            System.out.println(task);
        }
    }

    public void deleteTask(Task taskToBeDeleted) {
        Iterator<Task> deleteArr = tasks.iterator();
        while (deleteArr.hasNext()) {
            Task task = deleteArr.next();
            if (task == taskToBeDeleted) {
                deleteArr.remove();
                System.out.println("Task deleted: " + task);
                return;
            }
        }
        System.out.println("Task is not found!");
        return;
    }

    public static void main(String[] args) {
        /*
         * Update this are as per the user requirements like whick task to be added or
         * which task to be deleted or searched
         */
    }
}

/*
 * Analysis:
 * 
 * time complexity of add: O(1)
 * time complexity of search: O(N)
 * time complexity of traverse: O(N)
 * time complexity of delete: O(K), where K is the position of the kth data to
 * be deleted.
 * 
 * Avantages of Linked list over arrays are that they can be allocated on the
 * go, that is there is no fixed size, that means a linked list can store data
 * dynamically
 */
