class Solution {
    public String makeGood(String s) {
        
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(st.isEmpty()){
                st.push(s.charAt(i));
            }else{
                if(Math.abs(st.peek()-s.charAt(i))==32){
                    st.pop();
                }else{
                    st.push(s.charAt(i));
                }
            }
        }
        char[] ans=new char[st.size()];
        int i=st.size()-1;
        while(!st.isEmpty()){
            ans[i]=st.pop();
            i--;
        }
        return new String(ans);
    }
}