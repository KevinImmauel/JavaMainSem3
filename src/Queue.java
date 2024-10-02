public class Queue {
    int f = -1, r = -1, size = 5;
    int[] q = new int[size];
    void enQueue(int data){
        if(r == size - 1){
            System.out.println("Queue is full");
        } else {
            if (r == -1){
                q[++f] = data;
                ++r;
            } else {q[++r] = data;}
        }
    }
    void deQueue(){
        if(r == -1){
            System.out.println("Queue is empty");
        } else {
            if (f+1>r){
                f = -1;
                r = -1;
            } else {++f;}
        }
    }
    void display(){
        if (r == -1){
            System.out.println("Queue is empty");
        } else {
            System.out.println("-----Start of Queue-----");
            for (int i = f; i <= r; i++) {
                System.out.println(q[i]);
            }
            System.out.println("------End of Queue------");
        }
    }
    public static void main(String[] args) {
        Queue m = new Queue();
        m.enQueue(1);
        m.enQueue(2);
        m.enQueue(3);
        m.enQueue(4);
        m.enQueue(5);
        m.deQueue();
        Queue reversedQueue = new Queue();
        for (int i = m.r; i>= m.f; i--){
            reversedQueue.enQueue(m.q[i]);
        }
        reversedQueue.display();
    }
}
