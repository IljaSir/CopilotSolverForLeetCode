class Solution {
    public int countHomogenous(String s) {
        
        int count = 0;
        int result = 0;
        char prev = ' ';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == prev) {
                count++;
            } else {
                count = 1;
                prev = c;
            }
            result += count;
            result %= 1000000007;
        }
        return result;
    }
}