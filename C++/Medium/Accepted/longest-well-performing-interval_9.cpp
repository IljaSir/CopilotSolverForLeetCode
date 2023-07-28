class Solution {
public:
    int longestWPI(vector<int>& hours) {
        
        int n = hours.size();
        int ans = 0;
        vector<int> score(n+1, 0);
        for (int i = 0; i < n; ++i) {
            score[i+1] = score[i] + (hours[i] > 8 ? 1 : -1);
        }
        stack<int> stk;
        for (int i = 0; i <= n; ++i) {
            if (stk.empty() || score[stk.top()] > score[i]) {
                stk.push(i);
            }
        }
        for (int i = n; i >= 0; --i) {
            while (!stk.empty() && score[stk.top()] < score[i]) {
                ans = max(ans, i - stk.top());
                stk.pop();
            }
        }
        return ans;
    }
};