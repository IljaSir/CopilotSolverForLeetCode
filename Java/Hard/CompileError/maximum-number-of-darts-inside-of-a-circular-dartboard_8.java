class Solution {
    public int numPoints(int[][] darts, int r) {
        
        int n = darts.length;
        int ans = 1;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int[] p1 = darts[i];
                int[] p2 = darts[j];
                double dis = distance(p1,p2);
                if(dis>2*r) continue;
                double[] center = getCenter(p1,p2,r);
                int cnt = 0;
                for(int[] p:darts){
                    if(distance(p,center)<=r) cnt++;
                }
                ans = Math.max(ans,cnt);
            }
        }
        return ans;
    }
    
    private double distance(int[] p1, int[] p2){
        return Math.sqrt(Math.pow(p1[0]-p2[0],2)+Math.pow(p1[1]-p2[1],2));
    }
}