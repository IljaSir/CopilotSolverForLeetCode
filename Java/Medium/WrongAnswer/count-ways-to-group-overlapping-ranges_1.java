class Solution {
    public int countWays(int[][] ranges) {
        
        int n = ranges.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i = 0; i < n; i++){
            left[i] = ranges[i][0];
            right[i] = ranges[i][1];
        }
        Arrays.sort(left);
        Arrays.sort(right);
        int count = 0;
        int i = 0;
        int j = 0;
        int overlap = 0;
        while(i < n && j < n){
            if(left[i] <= right[j]){
                overlap++;
                i++;
            }else{
                overlap--;
                j++;
            }
            if(overlap == 0){
                count++;
            }
        }
        return (int)(Math.pow(2, count) % (Math.pow(10, 9) + 7));
    }
}