class Solution {
public:
    int shortestSubarray(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> prefix(n + 1);
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        deque<int> q;
        int ans = n + 1;
        for (int i = 0; i < n + 1; i++) {
            while (q.size() && prefix[i] - prefix[q.front()] >= k) {
                ans = min(ans, i - q.front());
                q.pop_front();
            }
            while (q.size() && prefix[i] <= prefix[q.back()]) {
                q.pop_back();
            }
            q.push_back(i);
        }
        return ans == n + 1 ? -1 : ans;
    }
};