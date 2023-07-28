class Solution {
    public String countAndSay(int n) {
        
        String s = "1";
        for(int i=2; i<=n; i++){
            s = countAndSay(s);
        }
        return s;
    }
    public String countAndSay(String s){
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i<s.length()){
            int j=i+1;
            while(j<s.length() && s.charAt(j)==s.charAt(i)){
                j++;
            }
            sb.append(j-i);
            sb.append(s.charAt(i));
            i = j;
        }
        return sb.toString();
    }
}