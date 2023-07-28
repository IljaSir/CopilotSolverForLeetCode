class Solution {
public:
    long long distinctNames(vector<string>& ideas) {
        
        long long res = 0;
        unordered_map<string, int> m;
        for (auto& s : ideas) {
            m[s]++;
        }
        for (auto& [s1, cnt1] : m) {
            for (auto& [s2, cnt2] : m) {
                if (s1 != s2) {
                    string s3 = s2;
                    s3[0] = s1[0];
                    string s4 = s1;
                    s4[0] = s2[0];
                    if (m.find(s3) == m.end() && m.find(s4) == m.end()) {
                        res += cnt1 * cnt2;
                    }
                }
            }
        }
        return res;
    }
};