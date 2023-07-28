class Solution {
public:
    vector<string> ambiguousCoordinates(string s) {
        
        vector<string> ans;
        for (int i = 1; i < s.size() - 2; ++i) {
            auto A = f(s.substr(1, i)), B = f(s.substr(i + 1, s.size() - i - 2));
            for (auto a: A) for (auto b: B) ans.push_back("(" + a + ", " + b + ")");
        }
        return ans;
    }
    vector<string> f(string s) {
        int n = s.size();
        vector<string> ans;
        for (int i = 1; i <= n; ++i) {
            string L = s.substr(0, i), R = s.substr(i);
            if ((L.size() == 1 || L[0] != '0') && R.back() != '0') ans.push_back(L + (i == n ? "" : ".") + R);
        }
        return ans;
    }
};