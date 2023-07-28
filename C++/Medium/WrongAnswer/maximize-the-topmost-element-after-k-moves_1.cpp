class Solution {
public:
    int maximumTop(vector<int>& nums, int k) {
        
        int n = nums.size();
        priority_queue<int> pq;
        for (int i = 0; i < n; i++) {
            pq.push(nums[i]);
        }
        for (int i = 0; i < k; i++) {
            if (pq.empty()) {
                break;
            }
            int top = pq.top();
            pq.pop();
            if (top > 0) {
                pq.push(top - 1);
            }
        }
        if (pq.empty()) {
            return -1;
        }
        return pq.top();
    }
};