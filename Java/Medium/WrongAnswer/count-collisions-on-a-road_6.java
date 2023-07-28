class Solution {
    public int countCollisions(String directions) {
        
        int n = directions.length();
        int ans = 0;
        int left = 0;
        int right = 0;
        for(int i = 0; i < n; i++) {
            char c = directions.charAt(i);
            if(c == 'L') {
                left++;
            } else if(c == 'R') {
                right++;
            } else {
                ans += Math.min(left, right);
                left = 0;
                right = 0;
            }
        }
        ans += Math.min(left, right);
        return ans;
    }
}