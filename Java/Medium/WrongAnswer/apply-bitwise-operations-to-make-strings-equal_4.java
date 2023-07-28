class Solution {
    public boolean makeStringsEqual(String s, String target) {
        
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            count += s.charAt(i) - '0';
            count -= target.charAt(i) - '0';
        }
        return count == 0;
    }
}