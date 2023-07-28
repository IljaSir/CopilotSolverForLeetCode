class Solution {
public:
    string crackSafe(int n, int k) {
        
        string ans(n, '0');
        unordered_set<string> seen;
        seen.insert(ans);
        int total = pow(k, n);
        for (int i = 0; i < total; i++) {
            string prev = ans.substr(ans.size() - n + 1);
            for (int j = k - 1; j >= 0; j--) {
                string next = prev + to_string(j);
                if (!seen.count(next)) {
                    seen.insert(next);
                    ans += to_string(j);
                    break;
                }
            }
        }
        return ans;
    }
};