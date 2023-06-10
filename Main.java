import java.util.LinkedList;
import java.util.Queue;

interface QueueBehaviour {
    void enqueue(String person);
    String dequeue();
    int size();
}

interface MarketBehaviour {
    void addPerson(String person);
    String removePerson();
    void update();
}

class Market implements QueueBehaviour, MarketBehaviour {
    private Queue<String> queue;

    public Market() {
        queue = new LinkedList<>();
    }

    @Override
    public void enqueue(String person) {
        queue.offer(person);
    }

    @Override
    public String dequeue() {
        return queue.poll();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public void addPerson(String person) {
        enqueue(person);
        System.out.println(person + " joined the queue.");
    }

    @Override
    public String removePerson() {
        String person = dequeue();
        System.out.println(person + " left the queue.");
        return person;
    }

    @Override
    public void update() {
        if (size() > 0) {
            String person = removePerson();
            processOrder(person);
        } else {
            System.out.println("No one in the queue. Market is idle.");
        }
    }

    private void processOrder(String person) {
        System.out.println("Processing order for " + person);
        // Perform order processing logic here
        // ...
        System.out.println("Order for " + person + " processed successfully.");
    }
}

public class Main {
    public static void main(String[] args) {
        Market market = new Market();

        market.addPerson("Person 1");
        market.addPerson("Person 2");
        market.update();
        market.update();
        market.addPerson("Person 3");
        market.update();
        market.update();
    }
}
