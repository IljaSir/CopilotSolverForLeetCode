class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        
        Arrays.sort(heaters);
        int max = 0;
        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
                index = -(index + 1);
            }
            int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
            int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
            max = Math.max(max, Math.min(dist1, dist2));
        }
        return max;
    }
}