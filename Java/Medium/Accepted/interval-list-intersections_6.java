class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        int i = 0;
        int j = 0;
        int m = firstList.length;
        int n = secondList.length;
        List<int[]> ans = new ArrayList<>();
        while (i < m && j < n) {
            int[] a = firstList[i];
            int[] b = secondList[j];
            int start = Math.max(a[0], b[0]);
            int end = Math.min(a[1], b[1]);
            if (start <= end) {
                ans.add(new int[]{start, end});
            }
            if (a[1] < b[1]) {
                i++;
            } else {
                j++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}