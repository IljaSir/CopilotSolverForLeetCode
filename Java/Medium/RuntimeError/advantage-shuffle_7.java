class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int[] ans = new int[n];
        Arrays.sort(nums1);
        for(int i = 0; i < n; i++){
            int index = binarySearch(nums1, nums2[i]);
            ans[i] = nums1[index];
            nums1[index] = -1;
        }
        return ans;
    }
    public int binarySearch(int[] nums, int target){
        int l = 0;
        int r = nums.length - 1;
        int ans = -1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] > target){
                ans = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        if(ans == -1){
            ans = l;
        }
        while(ans < nums.length && nums[ans] == -1){
            ans++;
        }
        return ans;
    }
}