class Solution {
    public int countHomogenous(String s) {
        
        int count = 1;
        int result = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                result = (result + (count * (count + 1) / 2)) % 1000000007;
                count = 1;
            }
        }
        result = (result + (count * (count + 1) / 2)) % 1000000007;
        return result;
    }
}