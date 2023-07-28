class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        
        int n = ranges.length;
        int[] covered = new int[right+1];
        for(int i=0; i<n; i++){
            for(int j=ranges[i][0]; j<=ranges[i][1]; j++){
                covered[j] = 1;
            }
        }
        for(int i=left; i<=right; i++){
            if(covered[i] == 0){
                return false;
            }
        }
        return true;
    }
}