class Solution {
    public int maxDistance(int[] position, int m) {
        
        Arrays.sort(position);
        int n = position.length;
        int left = 1;
        int right = position[n - 1] - position[0];
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(position, mid, m)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
    private boolean check(int[] position, int mid, int m) {
        int n = position.length;
        int last = position[0];
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (position[i] - last >= mid) {
                cnt++;
                last = position[i];
            }
        }
        return cnt >= m;
    }
}