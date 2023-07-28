class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int res = 0;
        int[] last = new int[2];
        for (int[] i : intervals) {
            if (i[0] > last[1]) {
                res += 2;
                last[0] = i[1] - 1;
                last[1] = i[1];
            } else if (i[0] > last[0]) {
                res += 1;
                last[0] = last[1];
                last[1] = i[1];
            }
        }
        return res;
    }
}