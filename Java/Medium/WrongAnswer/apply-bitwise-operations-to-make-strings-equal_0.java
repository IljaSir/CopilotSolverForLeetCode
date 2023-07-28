class Solution {
    public boolean makeStringsEqual(String s, String target) {
        
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != target.charAt(i)) {
                count++;
            }
        }
        return count % 2 == 0;
    }
}