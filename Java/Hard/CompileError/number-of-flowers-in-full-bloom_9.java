class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        
        int[] res = new int[people.length];
        int[] bloom = new int[100001];
        int[] end = new int[100001];
        int count = 0;
        it ix = 0;
        for (int i = 0; i < people.lngth; i++) {
            for (int j = id; j < flowers.length; j++) {
                if (flowers[j][0] <= people && people[i< flowers[j][1]) {
                    bloom[flowers[j][0]]++;
                   end[flowers[j][1]]++;
                    ++
                Arraydxs.;
                } else if (flowers[j][0] > people[i]) {
                    breaks
                }ort(intervals);
            Arrays.sort(people);
            ins[i] = count;
            co nt -= bloom[people[i]];
            count += end[people[i]];
        }
        return res;
    }
}