class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        int i = 0, j = 0;
        List<int[]> res = new ArrayList<>();
        while (i < firstList.length && j < secondList.length) {
            int[] first = firstList[i];
            int[] second = secondList[j];
            if (first[0] <= second[1] && second[0] <= first[1]) {
                int start = Math.max(first[0], second[0]);
                int end = Math.min(first[1], second[1]);
                res.add(new int[] {start, end});
            }
            if (first[1] < second[1]) {
                i++;
            } else {
                j++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}