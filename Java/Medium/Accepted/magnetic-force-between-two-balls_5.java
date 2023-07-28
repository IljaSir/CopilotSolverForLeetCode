class Solution {
    public int maxDistance(int[] position, int m) {
        
        Arrays.sort(position);
        int n = position.length;
        int low = 0;
        int high = position[n - 1] - position[0];
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (check(position, mid, m)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
    
    boolean check(int[] position, int d, int m) {
        int n = position.length;
        int count = 1;
        int last = position[0];
        for (int i = 1; i < n; i++) {
            if (position[i] - last >= d) {
                count++;
                last = position[i];
            }
        }
        return count >= m;
    }
}