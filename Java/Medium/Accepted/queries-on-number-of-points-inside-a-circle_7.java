class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        
        int[] result = new int[queries.length];
        
        for(int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int x = query[0];
            int y = query[1];
            int r = query[2];
            int count = 0;
            for(int j = 0; j < points.length; j++) {
                int[] point = points[j];
                int x1 = point[0];
                int y1 = point[1];
                double distance = Math.sqrt(Math.pow((x1 - x), 2) + Math.pow((y1 - y), 2));
                if(distance <= r) {
                    count++;
                }
            }
            result[i] = count;
        }
        
        return result;
    }
}