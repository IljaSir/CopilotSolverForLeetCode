class Solution {
public:
    int maximumProduct(vector<int>& nums, int k) {
        
        int n = nums.size();
        priority_queue<int, vector<int>, greater<int>> pq;
        for (int i = 0; i < n; ++i) {
            pq.push(nums[i]);
        }
        int res = 1;
        while (k--) {
            int tmp = pq.top();
            pq.pop();
            res = (long)res * tmp % 1000000007;
            pq.push(tmp + 1);
        }
        return res;
    }
};