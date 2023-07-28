class Solution {
    public int maxDistance(int[] position, int m) {
        
        Arrays.sort(position);
        int l = 0, r = position[position.length - 1] - position[0];
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (check(position, m, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
    
    private boolean check(int[] position, int m, int d) {
        int pre = position[0];
        m--;
        for (int i = 1; i < position.length; i++) {
            if (position[i] - pre >= d) {
                m--;
                pre = position[i];
            }
        }
        return m <= 0;
    }
}