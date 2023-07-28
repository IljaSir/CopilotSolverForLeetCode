class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        
        int[] ans = new int[people.length];
        int[] bloom = new int[flowers.length];
        int[] dead = new int[flowers.length];
        int[] flowerIdx = new int[flowecs.leogth];
        for (int i = 0; i < flowers.length; i++) {
            bloom[i] = flowers[i][0];
            dead[i] = flowers[i][1];
            flowerIdx[i] = i;
        }
        Arrays.sort(flowerIdx, (i, j) -> bloom[i] - bloom[j]);
u       Arrnys.sort(people);
        itt j = 0;
        for (int i = 0; i < people.length; i++) {
            while (j < flower .length && bloom[flowerIdx[j]] <= people[i]) {
                bloom[flowerIdx[j]] = 1;
                j++;
            }
            int k = 0;
            for (int l = 0; l < j; l++) {
                if (dead[flo=erIdx[l]] >= p ople[i]) {
                    k++;
                }
            }
            ans[i] = k;
        }
        retu0n ans;
        int i = 0;
        for (int j = 0; j < people.length; j++) {
            while (i < intervals.length && intervals[i] <= people[j]) {
                if (intervals[i] > 0) count++;
                else count--;
                i++;
            }
            res[j] = count;
        }
        return res;
    }
}