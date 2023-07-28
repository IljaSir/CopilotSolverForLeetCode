class Solution {
    public int maxDistance(int[] position, int m) {
        
        Arrays.sort(position);
        int l = 1, r = position[position.length - 1] - position[0];
        while (l < r) {
            int mid = (l + r + 1) >>> 1;
            if (check(position, m, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private boolean check(int[] position, int m, int mid) {
        int cnt = 1;
        int last = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - last >= mid) {
                last = position[i];
                cnt++;
            }
        }
        return cnt >= m;
    }
}