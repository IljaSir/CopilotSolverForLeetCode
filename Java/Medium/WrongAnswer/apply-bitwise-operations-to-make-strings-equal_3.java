class Solution {
    public boolean makeStringsEqual(String s, String target) {
        
        int countS = 0, countT = 0;
        for (int i = 0; i < s.length(); i++) {
            countS += s.charAt(i) - '0';
            countT += target.charAt(i) - '0';
        }
        return countS % 2 == countT % 2;
    }
}