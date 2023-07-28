class Solution {
    public int maxDistance(int[] position, int m) {
        
        Arrays.sort(position);
        int n = position.length;
        int left = 1;
        int right = position[n - 1] - position[0];
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (check(position, m, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    
    private boolean check(int[] position, int m, int mid) {
        int count = 1;
        int prev = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - prev >= mid) {
                count++;
                prev = position[i];
            }
        }
        return count >= m;
    }
}