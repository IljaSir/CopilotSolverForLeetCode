class Solution {
public:
    int minimumDeletions(vector<int>& nums) {
        
        int mx = *max_element(nums.begin(), nums.end());
        int mn = *min_element(nums.begin(), nums.end());
        return nums.size() - (find(nums.begin(), nums.end(), mx) - nums.begin() + 1) - (find(nums.rbegin(), nums.rend(), mn) - nums.rbegin() + 1);
    }
};