class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        
        vector<int> result;
        if (nums.size() == 0) {
            return result;
        }
        deque<int> dq;
        for (int i = 0; i < nums.size(); i++) {
            while (!dq.empty() && nums[dq.back()] < nums[i]) {
                dq.pop_back();
            }
            dq.push_back(i);
            if (i - dq.front() + 1 > k) {
                dq.pop_front();
            }
            if (i + 1 >= k) {
                result.push_back(nums[dq.front()]);
            }
        }
        return result;
    }
};