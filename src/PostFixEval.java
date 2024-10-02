public class PostFixEval {
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
        PostFixEval stack = new PostFixEval();
        String expression = "23*1-";
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            }else{
                int e2 = stack.pop();
                int e1 = stack.pop();
                switch (c){
                    case '+': stack.push(e1 + e2); break;
                    case '-': stack.push(e1 - e2); break;
                    case '*': stack.push(e1 * e2); break;
                    case '/': stack.push(e1 / e2); break;
                    case '^': stack.push((int) Math.pow(e1,e2));break;
                }
            }
        }
        System.out.println(stack.pop());
    }
}
