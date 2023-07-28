class Solution {
    public int findBestValue(int[] arr, int target) {
        
        Arrays.sort(arr);
        int n = arr.length;
        int[] prefix = new int[n+1];
        for(int i=1; i<=n; i++){
            prefix[i] = prefix[i-1] + arr[i-1];
        }
        int ans = 0;
        int diff = Integer.MAX_VALUE;
        for(int i=0; i<=arr[n-1]; i++){
            int idx = Arrays.binarySearch(arr, i);
            if(idx < 0){
                idx = -idx - 1;
            }
            int cur = prefix[idx] + (n-idx)*i;
            if(Math.abs(cur-target) < diff){
                ans = i;
                diff = Math.abs(cur-target);
            }
        }
        return ans;
    }
}