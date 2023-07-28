class Solution {
    public String digitSum(String s, int k) {
        
        if (s.length() <= k) {
            return s;
        }
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - '0';
        }
        return digitSum(String.valueOf(sum), k);
    }
}