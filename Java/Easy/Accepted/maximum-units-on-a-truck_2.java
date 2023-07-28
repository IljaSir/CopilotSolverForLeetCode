class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        int max = 0;
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });
        for (int[] box : boxTypes) {
            int n = Math.min(truckSize, box[0]);
            max += n * box[1];
            truckSize -= n;
            if (truckSize == 0) {
                break;
            }
        }
        return max;
    }
}