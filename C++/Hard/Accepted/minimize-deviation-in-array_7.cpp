class Solution {
public:
    int minimumDeviation(vector<int>& nums) {
        
        int n = nums.size();
        priority_queue<int> pq;
        int mn = INT_MAX;
        for (int i = 0; i < n; i++) {
            int x = nums[i] % 2 == 0 ? nums[i] : nums[i] * 2;
            mn = min(mn, x);
            pq.push(x);
        }
        int ans = INT_MAX;
        while (!pq.empty()) {
            int x = pq.top();
            pq.pop();
            ans = min(ans, x - mn);
            if (x % 2 == 0) {
                x /= 2;
                mn = min(mn, x);
                pq.push(x);
            } else {
                break;
            }
        }
        return ans;
    }
};