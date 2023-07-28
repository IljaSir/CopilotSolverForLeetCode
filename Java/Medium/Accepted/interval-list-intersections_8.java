class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        int i = 0;
        int j = 0;
        ArrayList<int[]> result = new ArrayList<>();
        while (i < firstList.length && j < secondList.length) {
            int[] a = firstList[i];
            int[] b = secondList[j];
            if (a[0] <= b[1] && b[0] <= a[1]) {
                result.add(new int[]{Math.max(a[0], b[0]), Math.min(a[1], b[1])});
            }
            if (a[1] < b[1]) i++;
            else j++;
        }
        return result.toArray(new int[result.size()][]);
    }
}