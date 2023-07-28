class Solution {
public:
    int maxUniqueSplit(string s) {
        
        int ans = 0;
        unordered_set<string> us;
        function<void(int)> dfs = [&](int i) {
            if (i == s.size()) {
                ans = max(ans, (int)us.size());
                return;
            }
            string tmp;
            for (int j = i; j < s.size(); ++j) {
                tmp += s[j];
                if (us.count(tmp) == 0) {
                    us.insert(tmp);
                    dfs(j + 1);
                    us.erase(tmp);
                }
            }
        };
        dfs(0);
        return ans;
    }
};