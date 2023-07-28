class Solution {
    public int calPoints(String[] operations) {
        
        int sum = 0;
        Stack<Integer> st = new Stack<>();
        for(String s : operations){
            if(s.equals("+")){
                int a = st.pop();
                int b = st.pop();
                int c = a + b;
                st.push(b);
                st.push(a);
                st.push(c);
                sum += c;
            }
            else if(s.equals("D")){
                int a = st.peek();
                st.push(2 * a);
                sum += 2 * a;
            }
            else if(s.equals("C")){
                int a = st.pop();
                sum -= a;
            }
            else{
                int a = Integer.parseInt(s);
                st.push(a);
                sum += a;
            }
        }
        return sum;
    }
}