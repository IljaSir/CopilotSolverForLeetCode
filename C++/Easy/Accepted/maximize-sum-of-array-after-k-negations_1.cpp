class Solution {
public:
    int largestSumAfterKNegations(vector<int>& nums, int k) {
        
        priority_queue<int, vector<int>, greater<int>> pq;
        for (int i = 0; i < nums.size(); i++) {
            pq.push(nums[i]);
        }
        while (k > 0) {
            int val = pq.top();
            pq.pop();
            pq.push(-val);
            k--;
        }
        int sum = 0;
        while (!pq.empty()) {
            sum += pq.top();
            pq.pop();
        }
        return sum;
    }
};