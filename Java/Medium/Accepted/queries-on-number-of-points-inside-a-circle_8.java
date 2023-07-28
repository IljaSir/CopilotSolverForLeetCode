class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        
        int[] result = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            for(int j=0; j<points.length; j++){
                int x = points[j][0] - queries[i][0];
                int y = points[j][1] - queries[i][1];
                if(x*x + y*y <= queries[i][2]*queries[i][2]){
                    result[i]++;
                }
            }
        }
        return result;
    }
}