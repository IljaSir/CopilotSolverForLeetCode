class Solution {
    public int minimumBuckets(String hamsters) {
        
        int count = 0;
        int left = 0;
        int right = 0;
        while (left < hamsters.length()) {
            while (left < hamsters.length() && hamsters.charAt(left) == 'H') {
                left++;
            }
            right = left;
            while (right < hamsters.length() && hamsters.charAt(right) == '.') {
                right++;
            }
            if (left == 0 && right == hamsters.length()) {
                return -1;
            }
            if (left == 0 || right == hamsters.length()) {
                count++;
            } else {
                count += (right - left + 1) / 3;
            }
            left = right;
        }
        return count;
    }
}