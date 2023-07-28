class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        
        int n = capacity.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(diff);
        int i = 0;
        while (i < n && additionalRocks >= diff[i]) {
            additionalRocks -= diff[i];
            i++;
        }
        return i;
    }
}