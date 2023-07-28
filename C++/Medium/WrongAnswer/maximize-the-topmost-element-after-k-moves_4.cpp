class Solution {
public:
    int maximumTop(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> v;
        for (int i = 0; i < n; ++i) {
            v.push_back(nums[i]);
        }
        sort(v.begin(), v.end());
        int ans = nums[0];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (v[j] > ans) {
                    ans = v[j];
                    --k;
                    if (k == 0) {
                        return ans;
                    }
                }
            }
        }
        return -1;
    }
};