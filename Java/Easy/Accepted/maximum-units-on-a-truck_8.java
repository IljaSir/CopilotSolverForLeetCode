class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        // sort by number of units
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int totalUnits = 0;
        for (int[] boxType : boxTypes) {
            int boxes = Math.min(truckSize, boxType[0]);
            totalUnits += boxes * boxType[1];
            truckSize -= boxes;
            if (truckSize == 0) {
                break;
            }
        }
        return totalUnits;
    }
}