class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        
        List<List<Long>> res = new ArrayList<>();
        int n = segments.length;
        long[] diff = new long[100001];
        for(int i = 0; i < n; i++){
            diff[segments[i][0]] += segments[i][2];
            diff[segments[i][1]] -= segments[i][2];
        }
        long sum = 0, prev = 0;
        for(int i = 1; i <= 100000; i++){
            sum += diff[i];
            if(sum > 0){
                if(prev > 0){
                    List<Long> list = new ArrayList<>();
                    list.add(prev);
                    list.add((long)i);
                    list.add(sum);
                    res.add(list);
                }
                prev = i;
            }
            else{
                prev = 0;
            }
        }
        return res;
    }
}