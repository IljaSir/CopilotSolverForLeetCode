class Solution {
    public int numSub(String s) {
        
        int count = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                result += count * (count + 1) / 2;
                count = 0;
            }
        }
        result += count * (count + 1) / 2;
        return result % 1000000007;
    }
}