class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        
        int[] ans = new int[2];
        int max = 0;
        for(int i=0;i<towers.length;i++){
            for(int j=0;j<towers.length;j++){
                int x = towers[j][0];
                int y = towers[j][1];
                int q = towers[j][2];
                int dist = (int)Math.sqrt((x-towers[i][0])*(x-towers[i][0]) + (y-towers[i][1])*(y-towers[i][1]));
                if(dist <= radius){
                    towers[i][2] += (int)Math.floor(q/(1+dist));
                }
            }
            if(towers[i][2] > max){
                max = towers[i][2];
                ans[0] = towers[i][0];
                ans[1] = towers[i][1];
            }
        }
        return ans;
    }
}