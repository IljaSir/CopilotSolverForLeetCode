class Solution {
    public int numTimesAllBlue(int[] flips) {
        
        int n = flips.length;
        int[] arr = new int[n+1];
        int max = 0;
        int count = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, flips[i]);
            arr[flips[i]] = 1;
            if(max == i + 1) {
                int j = 1;
                while(j <= i + 1 && arr[j] == 1) {
                    j++;
                }
                if(j == i + 2) {
                    count++;
                }
            }
        }
        return count;
    }
}