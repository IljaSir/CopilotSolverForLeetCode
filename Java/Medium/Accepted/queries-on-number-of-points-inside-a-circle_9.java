class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        
        int[] result = new int[queries.length];
        int index = 0;
        for(int[] query: queries){
            int count = 0;
            for(int[] point: points){
                if(Math.sqrt(Math.pow(point[0]-query[0], 2) + Math.pow(point[1]-query[1], 2)) <= query[2]){
                    count++;
                }
            }
            result[index++] = count;
        }
        return result;
    }
}