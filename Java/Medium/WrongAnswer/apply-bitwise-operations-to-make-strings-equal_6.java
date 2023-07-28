class Solution {
    public boolean makeStringsEqual(String s, String target) {
        
        int n = s.length();
        int[] count = new int[2];
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - '0']++;
            count[target.charAt(i) - '0']--;
        }
        return count[0] == 0 && count[1] == 0;
    }
}