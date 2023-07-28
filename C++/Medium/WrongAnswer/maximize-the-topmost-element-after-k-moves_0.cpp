class Solution {
public:
    int maximumTop(vector<int>& nums, int k) {
        
        priority_queue<int> pq;
        for (int i = 0; i < nums.size(); ++i) {
            pq.push(nums[i]);
        }
        for (int i = 0; i < k; ++i) {
            if (pq.empty()) {
                return -1;
            }
            int cur = pq.top();
            pq.pop();
            if (cur > 0) {
                pq.push(cur - 1);
            }
        }
        if (pq.empty()) {
            return -1;
        }
        return pq.top();
    }
};