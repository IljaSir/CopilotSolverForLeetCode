class Solution {
public:
    string removeKdigits(string num, int k) {
        
        if (num.size() == k) return "0";
        int n = num.size();
        int m = n - k;
        string ans;
        for (int i = 0; i < n; ++i) {
            while (!ans.empty() && ans.back() > num[i] && k) {
                ans.pop_back();
                --k;
            }
            ans.push_back(num[i]);
        }
        ans.resize(m);
        while (!ans.empty() && ans.front() == '0') ans.erase(ans.begin());
        return ans.empty() ? "0" : ans;
    }
};