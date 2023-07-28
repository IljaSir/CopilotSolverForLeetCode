class Solution {
public:
    int maxResult(vector<int>& nums, int k) {
        
        deque<int> q;
        int n = nums.size();
        q.push_back(0);
        for (int i = 1; i < n; i++) {
            nums[i] += nums[q.front()];
            while (!q.empty() && nums[q.back()] < nums[i]) {
                q.pop_back();
            }
            q.push_back(i);
            if (q.front() == i - k) {
                q.pop_front();
            }
        }
        return nums[n - 1];
    }
};