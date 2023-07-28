class Solution {
public:
    string removeKdigits(string num, int k) {
        
        int n = num.size();
        if (n == k) return "0";
        string ans = "";
        for (int i = 0; i < n; i++) {
            while (k && ans.size() && ans.back() > num[i]) {
                ans.pop_back();
                k--;
            }
            ans.push_back(num[i]);
        }
        while (k--) ans.pop_back();
        while (ans.size() && ans[0] == '0') ans.erase(ans.begin());
        return ans.size() ? ans : "0";
    }
};