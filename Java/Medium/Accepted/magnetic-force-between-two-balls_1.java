class Solution {
    public int maxDistance(int[] position, int m) {
        
        Arrays.sort(position);
        int n = position.length;
        int left = 1, right = position[n - 1] - position[0];
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (check(position, mid, m)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    private boolean check(int[] position, int d, int m) {
        int n = position.length;
        int count = 1;
        int prev = position[0];
        for (int i = 1; i < n; i++) {
            if (position[i] - prev >= d) {
                count++;
                prev = position[i];
            }
        }
        return count >= m;
    }
}