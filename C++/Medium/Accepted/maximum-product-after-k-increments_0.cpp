class Solution {
public:
    int maximumProduct(vector<int>& nums, int k) {
        
        int n = nums.size();
        priority_queue<int, vector<int>, greater<int>> pq(nums.begin(), nums.end());
        for (int i = 0; i < k; ++i) {
            int t = pq.top(); pq.pop();
            pq.push(t + 1);
        }
        long long res = 1;
        while (pq.size()) {
            res = res * pq.top() % 1000000007;
            pq.pop();
        }
        return res;
    }
};