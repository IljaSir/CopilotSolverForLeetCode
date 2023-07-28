class Solution {
    public int calPoints(String[] operations) {
        
        Stack<Integer> stack = new Stack<Integer>();
        int sum = 0;
        for(int i = 0; i < operations.length; i++){
            if(operations[i].equals("C")){
                sum -= stack.pop();
            }else if(operations[i].equals("D")){
                int temp = stack.peek() * 2;
                sum += temp;
                stack.push(temp);
            }else if(operations[i].equals("+")){
                int temp = stack.pop();
                int temp2 = stack.peek() + temp;
                sum += temp2;
                stack.push(temp);
                stack.push(temp2);
            }else{
                int temp = Integer.parseInt(operations[i]);
                sum += temp;
                stack.push(temp);
            }
        }
        return sum;
    }
}