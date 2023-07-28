class Solution {
    public int minimumTime(String s) {
        
        int n = s.length();
        int left = 0;
        int right = n - 1;
        int res = 0;
        while (left < n && s.charAt(left) == '0') {
            left++;
        }
        while (right >= 0 && s.charAt(right) == '0') {
            right--;
        }
        while (left <= right) {
            int count = 0;
            while (left <= right && s.charAt(left) == '0') {
                left++;
                count++;
            }
            res += count == 0 ? 2 : 1;
            left++;
        }
        return res;
    }
}