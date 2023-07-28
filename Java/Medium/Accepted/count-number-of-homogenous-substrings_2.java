class Solution {
    public int countHomogenous(String s) {
        
        int count = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i) != s.charAt(i - 1)) {
                count = 1;
            } else {
                count++;
            }
            result += count;
            result %= 1000000007;
        }
        return result;
    }
}