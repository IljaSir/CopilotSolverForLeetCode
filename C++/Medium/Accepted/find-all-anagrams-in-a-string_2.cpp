class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        
        vector<int> ans;
        int n = s.size();
        int m = p.size();
        if (m > n) return ans;
        vector<int> hash(26, 0);
        for (int i = 0; i < m; ++i) {
            hash[p[i] - 'a']++;
            hash[s[i] - 'a']--;
        }
        if (all_of(hash.begin(), hash.end(), [](int x){return x == 0;})) ans.push_back(0);
        for (int i = m; i < n; ++i) {
            hash[s[i] - 'a']--;
            hash[s[i - m] - 'a']++;
            if (all_of(hash.begin(), hash.end(), [](int x){return x == 0;})) ans.push_back(i - m + 1);
        }
        return ans;
    }
};