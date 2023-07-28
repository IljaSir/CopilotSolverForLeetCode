class Solution {
    public int countGoodSubstrings(String s) {
        
        int count = 0;
        int n = s.length();
        for (int i = 0; i < n - 2; i++) {
            String sub = s.substring(i, i + 3);
            if (sub.charAt(0) != sub.charAt(1) && sub.charAt(1) != sub.charAt(2) && sub.charAt(0) != sub.charAt(2))
                count++;
        }
        return count;
    }
}