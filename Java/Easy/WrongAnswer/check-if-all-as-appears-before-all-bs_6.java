class Solution {
    public boolean checkString(String s) {
        
        int n = s.length();
        int a = -1;
        int b = -1;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == 'a'){
                a = i;
            }
            if(s.charAt(i) == 'b'){
                b = i;
            }
        }
        return a < b;
    }
}