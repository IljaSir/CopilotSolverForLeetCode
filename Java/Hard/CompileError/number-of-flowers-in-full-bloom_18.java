class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        
        int[] ans = new int[people.length];
        int[] bloom = new int[flowers.length];
        int[] dead = new int[flowers.length];
        int[] flowerIdx = new int[flowers.length];
        for (int i = 0; i < flowers.length; i++) {
            bloom[i] = flowers[i][0];
            dead[i] = flowers[i][1];
            flowerIdx[i] = i;
        }
        Arrays.sort(flowerIdx, (i, j) -> bloom[i] - bloom[j]);
        Arrays.sort(people);
        int j = 0;
        for (int i = 0; i < people.length; i++) {
            while (j < flowers.length && bloom[flowerIdx[j]] <= people[i]) {
                bloom[flowerIdx[j]] = 1;
                j++;
            }
            int k = 0;
            for (int l = 0; l < j; l++) {
                if (dead[flowerIdx[l]] >= people[i]) {
                    k++;
                }
            }
            ans[i] = k;
        }
        return ans;
    }
}