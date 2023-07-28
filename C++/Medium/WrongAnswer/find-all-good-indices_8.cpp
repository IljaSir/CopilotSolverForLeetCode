class Solution {
public:
    vector<int> goodIndices(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> max_pre(n, 0);
        vector<int> min_post(n, 0);
        max_pre[k] = nums[k];
        for(int i = k + 1; i < n - k; i++) {
            max_pre[i] = max(max_pre[i - 1], nums[i]);
        }
        min_post[n - k - 1] = nums[n - k - 1];
        for(int i = n - k - 2; i >= k; i--) {
            min_post[i] = min(min_post[i + 1], nums[i]);
        }
        vector<int> res;
        for(int i = k; i < n - k; i++) {
            if(nums[i] >= max_pre[i - 1] && nums[i] <= min_post[i + 1]) {
                res.push_back(i);
            }
        }
        return res;
    }
};