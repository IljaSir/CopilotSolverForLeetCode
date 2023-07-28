class Solution {
public:
    long long distinctNames(vector<string>& ideas) {
        
        long long n = ideas.size();
        long long ans = 0;
        unordered_set<string> s;
        for (auto i : ideas) {
            s.insert(i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                string s1 = ideas[i], s2 = ideas[j];
                char c1 = s1[0], c2 = s2[0];
                s1[0] = c2;
                s2[0] = c1;
                if (s.find(s1) == s.end() && s.find(s2) == s.end()) {
                    ans++;
                }
            }
        }
        return ans;
    }
};