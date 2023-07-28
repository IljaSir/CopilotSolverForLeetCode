class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        int[][] result = new int[k][2];
        int[] dist = new int[points.length];
        for(int i=0;i<points.length;i++){
            dist[i] = points[i][0]*points[i][0] + points[i][1]*points[i][1];
        }
        Arrays.sort(dist);
        int dist_k = dist[k-1];
        int t = 0;
        for(int i=0;i<points.length;i++){
            if(points[i][0]*points[i][0] + points[i][1]*points[i][1] <= dist_k){
                result[t][0] = points[i][0];
                result[t][1] = points[i][1];
                t++;
            }
        }
        return result;
    }
}