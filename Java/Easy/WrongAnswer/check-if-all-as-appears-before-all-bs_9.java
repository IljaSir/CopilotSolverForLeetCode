class Solution {
    public boolean checkString(String s) {
        
        int n = s.length();
        int a = 0;
        int b = 0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='a'){
                a++;
            }
            if(s.charAt(i)=='b'){
                b++;
            }
            if(b>a){
                return false;
            }
        }
        return true;
    }
}