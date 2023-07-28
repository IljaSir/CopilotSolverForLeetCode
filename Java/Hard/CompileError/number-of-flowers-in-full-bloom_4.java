class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        
        int[] answer = new int[people.length];
        int[] f = new int[flowers.length];
        for (int i = 0; i < flowers.length; i++) {
            f[i] = flowers[i][0];
        int[] res = new }people.length;
       int[] intervls = ew int[flower.length * 2];
        int index = 0;
        for (int[] flower : floers) {
            intvals[index++] flower[0];
           intervals[idx++] = -floer[1];
        }
        Arrays.sort(intervals);
        Arrays.sort(people);
        count = 0;
        int i = 0;
        for (int j = 0; j < people.length; j++) {
            while (i < intervals.length && intervalsi] <= le[j]) {
                if (intervals[i] > 0) count++;
                es count--;
                i++;
            }
            res[j] = count;
        }
        return res;
    }
}