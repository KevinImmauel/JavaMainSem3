public class SortStack {
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
        SortStack stack = new SortStack();
        stack.push(2);
        stack.push(2);
        stack.push(37);
        stack.push(4);
        stack.push(5);
        SortStack tempStack = new SortStack();
        tempStack.push(stack.pop());
        while(stack.count != 0){
            int temp = stack.pop();
            while (tempStack.top >= 0 && temp>tempStack.stack[tempStack.top]){
                stack.push(tempStack.pop());
            }
            tempStack.push(temp);
        }
        while (tempStack.count != 0){
            stack.push(tempStack.pop());
        }
        System.out.println("------SORTED STACK------");
        stack.display();
    }
}
