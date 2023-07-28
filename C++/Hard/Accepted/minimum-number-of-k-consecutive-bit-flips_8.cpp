class Solution {
public:
    int minKBitFlips(vector<int>& nums, int k) {
        
        int n = nums.size();
        int ans = 0;
        queue<int> q;
        for (int i = 0; i < n; ++i) {
            if (q.size() && i - q.front() >= k) q.pop();
            if (q.size() % 2 == nums[i]) {
                if (i + k > n) return -1;
                ans++;
                q.push(i);
            }
        }
        return ans;
    }
};