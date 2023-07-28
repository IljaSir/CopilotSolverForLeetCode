class Solution {
public:
    int minimumDeviation(vector<int>& nums) {
        
        int n = nums.size();
        priority_queue<int> pq;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 1) {
                nums[i] *= 2;
            }
            pq.push(nums[i]);
        }
        int ans = pq.top() - pq.top() / 2;
        while (pq.top() % 2 == 0) {
            int x = pq.top();
            pq.pop();
            pq.push(x / 2);
            ans = min(ans, pq.top() - pq.top() / 2);
        }
        return ans;
    }
};