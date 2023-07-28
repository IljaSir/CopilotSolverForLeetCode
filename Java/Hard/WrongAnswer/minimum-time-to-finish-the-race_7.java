class Solution {
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return a - b;
            }
        });
        for(int i = 0; i < tires.length; i++){
            pq.add(tires[i][0]);
        }
        int ans = 0;
        while(numLaps > 0){
            int cur = pq.poll();
            ans += cur;
            numLaps--;
            pq.add(cur + changeTime);
        }
        return ans;
    }
}