class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int mod = (int)1e9 + 7;
        int[] rec = new int[n];
        System.arraycopy(nums1, 0, rec, 0, n);
        Arrays.sort(rec);
        int sum = 0, maxn = 0;
        for(int i = 0; i < n; i++){
            int diff = Math.abs(nums1[i] - nums2[i]);
            sum = (sum + diff) % mod;
            int j = binarySearch(rec, nums2[i]);
            if(j < n){
                maxn = Math.max(maxn, diff - (rec[j] - nums2[i]));
            }
            if(j > 0){
                maxn = Math.max(maxn, diff - (nums2[i] - rec[j - 1]));
            }
        }
        return (sum - maxn + mod) % mod;
    }
    public int binarySearch(int[] nums, int target){
        int low = 0, high = nums.length - 1;
        if(nums[high] < target){
            return high + 1;
        }
        while(low < high){
            int mid = (high - low) / 2 + low;
            if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }
}