class Solution {
public:
    int maximumTop(vector<int>& nums, int k) {
        
        int n = nums.size();
        if (n == 1) return nums[0] > k ? -1 : nums[0];
        priority_queue<int> pq;
        for (int i = 0; i < n; ++i) {
            pq.push(nums[i]);
        }
        int res = pq.top();
        for (int i = 0; i < k; ++i) {
            int top = pq.top();
            pq.pop();
            if (top == 0) return -1;
            pq.push(top - 1);
            res = max(res, top - 1);
        }
        return res;
    }
};