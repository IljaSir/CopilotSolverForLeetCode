class Solution {
    public long countBadPairs(int[] nums) {
        
        int n = nums.length;
        long ans = 0;
        for(int i = 0; i < n; i++){
            int diff = nums[i] - i;
            int l = i + 1;
            int r = n - 1;
            while(l <= r){
                int mid = l + (r - l) / 2;
                if(nums[mid] - mid >= diff){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
            ans += (n - l);
        }
        return ans;
    }
}