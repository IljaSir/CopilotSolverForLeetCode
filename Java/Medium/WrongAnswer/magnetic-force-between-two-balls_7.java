class Solution {
    public int maxDistance(int[] position, int m) {
        
        Arrays.sort(position);
        int left = 0;
        int right = position[position.length-1] - position[0];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(position, m, mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }
    private boolean check(int[] position, int m, int mid) {
        int count = 1;
        int i = 0;
        for (int j = 1; j < position.length; j++) {
            if (position[j] - position[i] >= mid) {
                count++;
                i = j;
            }
        }
        return count >= m;
    }
}