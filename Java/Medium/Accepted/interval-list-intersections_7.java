class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        List<int[]> list = new ArrayList<int[]>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            int[] first = firstList[i];
            int[] second = secondList[j];
            int[] intersection = new int[2];
            if (first[1] < second[0]) {
                i++;
            } else if (first[0] > second[1]) {
                j++;
            } else {
                intersection[0] = Math.max(first[0], second[0]);
                intersection[1] = Math.min(first[1], second[1]);
                list.add(intersection);
                if (first[1] > second[1]) {
                    j++;
                } else {
                    i++;
                }
            }
        }
        int[][] result = new int[list.size()][2];
        for (int k = 0; k < list.size(); k++) {
            result[k] = list.get(k);
        }
        return result;
    }
}