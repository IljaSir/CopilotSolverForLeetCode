class Solution {
    public String removeStars(String s) {
        
        int n = s.length();
        char[] ch = s.toCharArray();
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            if(ch[i] == '*'){
                st.push(i);
            }
            else{
                if(!st.isEmpty()){
                    int pos = st.pop();
                    ch[pos] = ch[i];
                    ch[i] = '*';
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            if(ch[i] != '*'){
                sb.append(ch[i]);
            }
        }
        return sb.toString();
    }
}