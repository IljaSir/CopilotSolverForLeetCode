class Solution {
public:
    int longestWPI(vector<int>& hours) {
        
        int len = hours.size();
        vector<int> prefix(len + 1, 0);
        for (int i = 1; i <= len; i++) {
            prefix[i] = prefix[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
        }
        stack<int> stk;
        for (int i = 0; i <= len; i++) {
            if (stk.empty() || prefix[i] < prefix[stk.top()]) {
                stk.push(i);
            }
        }
        int res = 0;
        for (int i = len; i >= 0; i--) {
            while (!stk.empty() && prefix[i] > prefix[stk.top()]) {
                res = max(res, i - stk.top());
                stk.pop();
            }
        }
        return res;
    }
};