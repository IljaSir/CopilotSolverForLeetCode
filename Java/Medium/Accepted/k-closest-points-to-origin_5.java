class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        int[][] res = new int[k][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]);
            }
        });
        for(int i = 0; i < points.length; i++){
            pq.add(points[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }
        int index = 0;
        while(!pq.isEmpty()){
            res[index++] = pq.poll();
        }
        return res;
    }
}