class Solution {
public:
    string removeKdigits(string num, int k) {
        
        string ans;
        int n = num.size();
        for (int i = 0; i < n; i++) {
            while (k > 0 && !ans.empty() && ans.back() > num[i]) {
                ans.pop_back();
                k--;
            }
            if (ans.empty() && num[i] == '0') continue;
            ans.push_back(num[i]);
        }
        while (k-- > 0) {
            ans.pop_back();
        }
        if (ans.empty()) return "0";
        return ans;
    }
};