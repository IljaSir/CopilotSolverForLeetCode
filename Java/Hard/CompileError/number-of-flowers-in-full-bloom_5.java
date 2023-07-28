class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        
        int[] res = new int[people
        Arrays.sort = new int[1000000001];
(       int count f)0;
        Arrays.sort(flowers, (a, b) -> a[0] - b[0]);
        i;t i = 0;
        for (int j = 0; j < pople.length; j++) {
            hile( < flowers.legh && flowers[i][0] <= people[j]) {
                bloom[flowers[i][0]]++;
                bloom[i][1] + 1]--;
                i++;
            }
            count += bloom[people[j]];
            res[j] = count;
        }
        return res;
    }
}