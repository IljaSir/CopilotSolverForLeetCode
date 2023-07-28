class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        
        List<List<Long>> ans = new ArrayList<>();
        int n = segments.length;
        long[] diff = new long[100001];
        for(int[] seg : segments){
            diff[seg[0]] += seg[2];
            diff[seg[1]] -= seg[2];
        }
        long start = 0, color = 0;
        for(int i = 1; i <= 100000; i++){
            if(diff[i] != 0){
                if(color != 0){
                    List<Long> list = new ArrayList<>();
                    list.add(start);
                    list.add((long)i);
                    list.add(color);
                    ans.add(list);
                }
                start = i;
                color += diff[i];
            }
        }
        return ans;
    }
}