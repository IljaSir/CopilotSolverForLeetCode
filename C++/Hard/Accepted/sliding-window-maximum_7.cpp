class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        
        vector<int> result;
        if (nums.size() == 0) return result;
        deque<int> dq;
        for (int i = 0; i < nums.size(); ++i) {
            if (dq.size() > 0 && dq.front() < i - k + 1) {
                dq.pop_front();
            }
            while (dq.size() > 0 && nums[dq.back()] < nums[i]) {
                dq.pop_back();
            }
            dq.push_back(i);
            if (i >= k - 1) {
                result.push_back(nums[dq.front()]);
            }
        }
        return result;
    }
};