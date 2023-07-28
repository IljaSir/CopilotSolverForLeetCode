class Solution {
    public int minFlips(String target) {
        
        int result = 0;
        char last = '0';
        for (char c : target.toCharArray()) {
            if (c != last) {
                result++;
                last = c;
            }
        }
        return result;
    }
}