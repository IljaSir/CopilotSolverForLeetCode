class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int maxUnits = 0;
        for (int[] box : boxTypes) {
            int n = Math.min(truckSize, box[0]);
            maxUnits += n * box[1];
            truckSize -= n;
            if (truckSize == 0) {
                break;
            }
        }
        return maxUnits;
    }
}