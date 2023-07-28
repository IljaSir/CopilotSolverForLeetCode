class Solution {
public:
    string getHappyString(int n, int k) {
        
        vector<string> v = {"a", "b", "c"};
        for (int i = 2; i <= n; ++i) {
            vector<string> tmp;
            for (auto s : v) {
                for (auto c : string("abc")) {
                    if (s.back() != c) {
                        tmp.push_back(s + c);
                    }
                }
            }
            v = tmp;
        }
        return k <= v.size() ? v[k-1] : "";
    }
};