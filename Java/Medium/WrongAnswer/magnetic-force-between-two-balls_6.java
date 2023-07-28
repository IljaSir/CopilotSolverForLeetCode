class Solution {
    public int maxDistance(int[] position, int m) {
        
        Arrays.sort(position);
        int min = 1, max = position[position.length - 1] - position[0];
        while (min < max) {
            int mid = min + (max - min) / 2;
            int count = 1, prev = position[0];
            for (int i = 1; i < position.length; i++) {
                if (position[i] - prev >= mid) {
                    count++;
                    prev = position[i];
                }
            }
            if (count >= m) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min - 1;
    }
}