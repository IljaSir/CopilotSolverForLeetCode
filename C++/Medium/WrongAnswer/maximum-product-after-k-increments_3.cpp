class Solution {
public:
    int maximumProduct(vector<int>& nums, int k) {
        
        int n = nums.size();
        priority_queue<int, vector<int>, greater<int>> pq;
        for (int i = 0; i < n; i++) {
            pq.push(nums[i]);
        }
        int mod = 1e9 + 7;
        long long res = 1;
        for (int i = 0; i < k; i++) {
            int cur = pq.top();
            pq.pop();
            res = res * cur % mod;
        }
        return res;
    }
};