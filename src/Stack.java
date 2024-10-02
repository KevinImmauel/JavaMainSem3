public class Stack {
    int top = -1, size = 5, count = 0;
    int[] stack = new int[size];
    void push(int data){
        if(count == size){
            System.out.println("Stack is full");
        }else{
            stack[++top] = data;
            count++;
        }
    }
    int pop(){
        if(count == 0){
            System.out.println("Stack is empty");
            return -1;
        }
        else{
            count--;
            return stack[top--];
        }
    }
    void display(){
        if(count == 0){
            System.out.println("Stack is empty");
        }else {
            System.out.println("-----Start of Stack-----");
            for (int i = 0; i <= top; i++) {
                System.out.println(stack[i]);
            }
            System.out.println("------End of Stack------");
        }
    }
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(2);
        stack.push(2);
        stack.push(37);
        stack.push(4);
        stack.push(5);
        stack.display();
    }
}
