class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < firstList.length && j < secondList.length) {
            int[] first = firstList[i];
            int[] second = secondList[j];
            if (first[1] < second[0]) {
                i++;
            } else if (first[0] > second[1]) {
                j++;
            } else {
                result.add(new int[]{Math.max(first[0], second[0]), Math.min(first[1], second[1])});
                if (first[1] < second[1]) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}