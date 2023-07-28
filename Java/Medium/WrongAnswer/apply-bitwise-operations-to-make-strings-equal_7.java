class Solution {
    public boolean makeStringsEqual(String s, String target) {
        
        int a = 0;
        int b = 0;
        for(int i = 0; i < s.length(); i++){
            a ^= s.charAt(i);
            b ^= target.charAt(i);
        }
        return a == b;
    }
}