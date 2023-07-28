class Solution {
public:
    string removeKdigits(string num, int k) {
        
        int n = num.size();
        if (k >= n) return "0";
        stack<char> stk;
        for (auto c : num) {
            while (stk.size() && stk.top() > c && k) {
                stk.pop();
                k--;
            }
            stk.push(c);
        }
        while (k--) {
            stk.pop();
        }
        string ans = "";
        while (stk.size()) {
            ans += stk.top();
            stk.pop();
        }
        reverse(ans.begin(), ans.end());
        int i = 0;
        while (i < ans.size() && ans[i] == '0') i++;
        if (i == ans.size()) return "0";
        return ans.substr(i);
    }
};