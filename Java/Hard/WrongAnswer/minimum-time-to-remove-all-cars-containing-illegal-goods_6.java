class Solution {
    public int minimumTime(String s) {
        
        int result = 0;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;
            } else {
                if (count > 0) {
                    result++;
                    count = 0;
                }
            }
        }
        if (count > 0) {
            result += 2;
        }
        return result;
    }
}