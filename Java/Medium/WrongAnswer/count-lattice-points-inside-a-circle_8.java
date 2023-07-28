class Solution {
    public int countLatticePoints(int[][] circles) {
        
        int count = 0;
        for(int i = 1; i < 101; i++){
            for(int j = 1; j < 101; j++){
                for(int[] circle : circles){
                    if((i - circle[0]) * (i - circle[0]) + (j - circle[1]) * (j - circle[1]) <= circle[2] * circle[2]){
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }
}