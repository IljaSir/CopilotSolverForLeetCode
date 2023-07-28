class Solution {
    public int minimumTime(String s) {
        
        int left = 0;
        int right = s.length() - 1;
        while (left < s.length() && s.charAt(left) == '0') {
            left++;
        }
        while (right >= 0 && s.charAt(right) == '0') {
            right--;
        }
        if (left > right) {
            return 0;
        }
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        return count * 2 - 1;
    }
}