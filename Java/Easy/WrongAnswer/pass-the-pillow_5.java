class Solution {
    public int passThePillow(int n, int time) {
        
        int left = 1;
        int right = n;
        int direction = 1;
        int t = 0;
        while (t < time) {
            if (direction == 1) {
                if (left < right) {
                    left++;
                } else {
                    direction = 0;
                    left--;
                }
            } else {
                if (left > right) {
                    left--;
                } else {
                    direction = 1;
                    left++;
                }
            }
            t++;
        }
        return left;
    }
}