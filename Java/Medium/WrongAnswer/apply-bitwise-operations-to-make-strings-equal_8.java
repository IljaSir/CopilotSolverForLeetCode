class Solution {
    public boolean makeStringsEqual(String s, String target) {
        
        int c1 = 0, c2 = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '1') c1++;
            if(target.charAt(i) == '1') c2++;
        }
        return c1 == c2;
    }
}