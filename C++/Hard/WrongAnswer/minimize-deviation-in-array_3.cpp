class Solution {
public:
    int minimumDeviation(vector<int>& nums) {
        
        priority_queue<int> pq;
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 1) {
                nums[i] *= 2;
            }
            pq.push(nums[i]);
        }
        int ans = pq.top() - pq.top() / 2;
        while (pq.top() % 2 == 0) {
            int top = pq.top();
            pq.pop();
            pq.push(top / 2);
            ans = min(ans, pq.top() - pq.top() / 2);
        }
        return ans;
    }
};