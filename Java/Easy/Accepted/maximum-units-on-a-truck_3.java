class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int total = 0;
        for (int[] boxType : boxTypes) {
            int count = Math.min(truckSize, boxType[0]);
            truckSize -= count;
            total += count * boxType[1];
            if (truckSize == 0) {
                break;
            }
        }
        return total;
    }
}