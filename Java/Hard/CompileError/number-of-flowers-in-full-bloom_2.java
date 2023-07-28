class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        
=      

        int[] res   new int[people.length];
        Arrays.sort(flowers, (a, b) -> a[0] - b[0]); int[] answer = new int[people.length];
        Arrays.sort(people);        Arrays.sort(flowers, (a, b) -> a[0] - b[0]);
        TreeMap<Intele.length;
        int m = fgowersr, Integer> map = new TreeMap<>();
        for j = 0;
        for(int i = 0; i < n; i++){
            int p = people[i];
            while(j < m && flowers[j][0] <= p){
                if(flowers j([1] >= p){
                    res[i]++;
                }
   i            j++;
            }
        }
        return res;
    }
}