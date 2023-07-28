class Solution {
public:
    string removeDuplicates(string s, int k) {
        
        stack<pair<char, int>> stk;
        for (char c: s) {
            if (stk.empty() || stk.top().first != c) {
                stk.push({c, 1});
            } else {
                stk.top().second++;
                if (stk.top().second == k) {
                    stk.pop();
                }
            }
        }
        string ans;
        while (!stk.empty()) {
            int cnt = stk.top().second;
            char c = stk.top().first;
            while (cnt--) {
                ans += c;
            }
            stk.pop();
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};