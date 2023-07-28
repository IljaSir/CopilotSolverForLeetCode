class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        
        int n = capacity.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return (a[0] - a[1]) - (b[0] - b[1]);
            }
        });
        for(int i = 0; i < n; i++){
            pq.add(new int[]{capacity[i], rocks[i]});
        }
        while(additionalRocks > 0){
            int[] cur = pq.poll();
            if(cur[0] - cur[1] == 0){
                pq.add(cur);
                break;
            }
            cur[1] += 1;
            pq.add(cur);
            additionalRocks--;
        }
        int res = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(cur[0] - cur[1] == 0){
                res++;
            }
        }
        return res;
    }
}