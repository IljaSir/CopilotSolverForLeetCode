class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        
        vector<int> result;
        if (nums.size() == 0) return result;
        deque<int> dq;
        dq.push_back(nums[0]);
        for (int i = 1; i < k; i++) {
            while (!dq.empty() && dq.back() < nums[i]) {
                dq.pop_back();
            }
            dq.push_back(nums[i]);
        }
        result.push_back(dq.front());
        for (int i = k; i < nums.size(); i++) {
            if (dq.front() == nums[i - k]) {
                dq.pop_front();
            }
            while (!dq.empty() && dq.back() < nums[i]) {
                dq.pop_back();
            }
            dq.push_back(nums[i]);
            result.push_back(dq.front());
        }
        return result;
    }
};