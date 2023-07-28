class Solution {
public:
    int maxFreq(string s, int maxLetters, int minSize, int maxSize) {
        
        int n = s.size();
        unordered_map<string, int> mp;
        for (int i = 0; i < n - minSize + 1; ++i) {
            string sub = s.substr(i, minSize);
            unordered_set<char> st;
            for (auto c: sub) {
                st.insert(c);
            }
            if (st.size() <= maxLetters) {
                mp[sub]++;
            }
        }
        int ans = 0;
        for (auto [k, v]: mp) {
            ans = max(ans, v);
        }
        return ans;
    }
};