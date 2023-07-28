class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        if (firstList == null || secondList == null) {
            return new int[0][0];
        }
        int i = 0, j = 0;
        List<int[]> list = new ArrayList<>();
        while (i < firstList.length && j < secondList.length) {
            int[] first = firstList[i];
            int[] second = secondList[j];
            if (first[0] <= second[1] && second[0] <= first[1]) {
                list.add(new int[]{Math.max(first[0], second[0]), Math.min(first[1], second[1])});
            }
            if (first[1] < second[1]) {
                i++;
            } else {
                j++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}