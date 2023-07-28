class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        
        int[] ans = new int[2];
        int max = 0;
        for(int i = 0; i < towers.length; i++){
            for(int j = 0; j < towers.length; j++){
                int sum = 0;
                for(int k = 0; k < towers.length; k++){
                    if(Math.sqrt(Math.pow(towers[k][0] - towers[j][0], 2) + Math.pow(towers[k][1] - towers[j][1], 2)) <= radius){
                        sum += (int)(towers[k][2] / (1 + Math.sqrt(Math.pow(towers[k][0] - towers[j][0], 2) + Math.pow(towers[k][1] - towers[j][1], 2))));
                    }
                }
                if(sum > max){
                    max = sum;
                    ans[0] = towers[j][0];
                    ans[1] = towers[j][1];
                }else if(sum == max){
                    if(ans[0] > towers[j][0]){
                        ans[0] = towers[j][0];
                        ans[1] = towers[j][1];
                    }else if(ans[0] == towers[j][0]){
                        if(ans[1] > towers[j][1]){
                            ans[0] = towers[j][0];
                            ans[1] = towers[j][1];
                        }
                    }
                }
            }
        }
        return ans;
    }
}