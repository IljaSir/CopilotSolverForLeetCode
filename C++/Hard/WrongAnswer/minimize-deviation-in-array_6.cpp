class Solution {
public:
    int minimumDeviation(vector<int>& nums) {
        
        int n = nums.size();
        priority_queue<int, vector<int>, greater<int>> pq;
        for (int i = 0; i < n; i++) {
            pq.push(nums[i] % 2 == 1 ? nums[i] * 2 : nums[i]);
        }
        int res = pq.top() - pq.top() % 2;
        while (pq.top() % 2 == 0) {
            int x = pq.top();
            pq.pop();
            pq.push(x / 2);
            res = min(res, pq.top() - pq.top() % 2);
        }
        return res;
    }
};