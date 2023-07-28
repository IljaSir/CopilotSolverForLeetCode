class Solution {
public:
    int constrainedSubsetSum(vector<int>& nums, int k) {
        
        int n = nums.size();
        deque<int> q;
        int res = INT_MIN;
        for (int i = 0; i < n; ++i) {
            if (!q.empty()) {
                nums[i] = max(nums[i], nums[q.front()] + nums[i]);
            }
            while (!q.empty() && nums[q.back()] <= nums[i]) {
                q.pop_back();
            }
            q.push_back(i);
            if (q.front() == i - k) {
                q.pop_front();
            }
            res = max(res, nums[i]);
        }
        return res;
    }
};