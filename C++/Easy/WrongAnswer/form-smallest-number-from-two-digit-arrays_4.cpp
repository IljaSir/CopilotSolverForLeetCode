class Solution {
public:
    int minNumber(vector<int>& nums1, vector<int>& nums2) {
        
        int n1 = nums1.size();
        int n2 = nums2.size();
        int n = n1 + n2;
        vector<int> nums(n);
        for(int i = 0; i < n1; i++){
            nums[i] = nums1[i];
        }
        for(int i = 0; i < n2; i++){
            nums[n1 + i] = nums2[i];
        }
        sort(nums.begin(), nums.end());
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans = ans * 10 + nums[i];
        }
        return ans;
    }
};