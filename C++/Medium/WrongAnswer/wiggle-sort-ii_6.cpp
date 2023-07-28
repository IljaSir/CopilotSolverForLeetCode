class Solution {
public:
    void wiggleSort(vector<int>& nums) {
        
        auto n = nums.size();
        auto m = (n+1)/2;
        nth_element(nums.begin(), nums.begin()+m-1, nums.end());
        nth_element(nums.begin()+m, nums.end(), nums.end());
        vector<int> ans(n);
        int i = 0, j = m-1, k = n-1;
        while (i < n) {
            ans[i] = nums[j];
            if (i+1 < n) ans[i+1] = nums[k];
            i += 2;
            j--;
            k--;
        }
        nums = ans;
    }
};