class Solution {
    public int numSub(String s) {
        
        int count = 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
                sum = (sum + count) % 1000000007;
            } else {
                count = 0;
            }
        }
        return sum;
    }
}