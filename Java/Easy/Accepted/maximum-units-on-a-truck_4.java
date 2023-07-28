class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        int res = 0;
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        for (int[] box : boxTypes) {
            int cnt = Math.min(truckSize, box[0]);
            res += cnt * box[1];
            truckSize -= cnt;
            if (truckSize == 0) {
                break;
            }
        }
        return res;
    }
}