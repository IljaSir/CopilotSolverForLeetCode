class Solution {
    public int countCollisions(String directions) {
        
        int count = 0;
        int left = 0;
        int right = 0;
        int stationary = 0;
        for (char c : directions.toCharArray()) {
            if (c == 'L') {
                left++;
                count += right;
            } else if (c == 'R') {
                right++;
                count += stationary;
            } else {
                stationary++;
                count += right;
            }
        }
        return count;
    }
}