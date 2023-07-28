class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            int[] first = firstList[i];
            int[] second = secondList[j];
            if (first[0] <= second[0] && first[1] >= second[0]) {
                res.add(new int[]{second[0], Math.min(first[1], second[1])});
            } else if (second[0] <= first[0] && second[1] >= first[0]) {
                res.add(new int[]{first[0], Math.min(first[1], second[1])});
            }
            if (first[1] < second[1]) i++;
            else j++;
        }
        return res.toArray(new int[0][]);
    }
}