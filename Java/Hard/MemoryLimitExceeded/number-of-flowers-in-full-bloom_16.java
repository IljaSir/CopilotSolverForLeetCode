class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        
        int[] res = new int[people.length];
        int[] bloom = new int[1000000001];
        int count = 0;
        Arrays.sort(flowers, (a, b) -> a[0] - b[0]);
        int i = 0;
        for (int j = 0; j < people.length; j++) {
            while (i < flowers.length && flowers[i][0] <= people[j]) {
                bloom[flowers[i][0]]++;
                bloom[flowers[i][1] + 1]--;
                i++;
            }
            count += bloom[people[j]];
            res[j] = count;
        }
        return res;
    }
}