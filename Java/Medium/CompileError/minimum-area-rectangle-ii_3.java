class Solution {
    public double minAreaFreeRect(int[][] points) {
        
        int n = points.length;
        double ans = Double.MAX_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                for(int k = j + 1; k < n; k++){
                    for(int l = k + 1; l < n; l++){
                        if(isRectangle(points[i], points[j], points[k], points[l])){
                            ans = Math.min(ans, area(points[i], points[j], points[k], points[l]));
                        }
                    }
                }
            }
        }
        return ans == Double.MAX_VALUE ? 0 : ans;
    }
    public boolean isRectangle(int[] p1, int[] p2, int[] p3, int[] p4){
        int[] v1 = {p2[0] - p1[0], p2[1] - p1[1]};
        int[] v2 = {p3[0] - p1[0], p3[1] - p1[1]};
        int[] v3 = {p4[0] - p1[0], p4[1] - p1[1]};
        if(v1[0] * v2[0] + v1[1] * v2[1] != 0) return false;
        if(v1[0] * v3[0] + v1[1] * v3[1] != 0) return false;
        if(v2[0] * v3[0] + v2[1] * v3[1] != 0) return false;
        return true;
    }
}