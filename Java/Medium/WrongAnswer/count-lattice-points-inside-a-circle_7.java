class Solution {
    public int countLatticePoints(int[][] circles) {
        
        int ans = 0;
        for(int[] c : circles){
            int x = c[0], y = c[1], r = c[2];
            for(int i = x-r; i <= x+r; i++){
                if(i < 1 || i > 100) continue;
                int d = (int)Math.sqrt(r*r - (i-x)*(i-x));
                ans += Math.max(0, Math.min(100, y+d) - Math.max(1, y-d) + 1);
            }
        }
        return ans;
    }
}