class Solution {
public:
    int maxFreq(string s, int maxLetters, int minSize, int maxSize) {
        
        map<string, int> m;
        int n = s.size();
        for (int i = 0; i < n; i++) {
            if (i + minSize > n) break;
            set<char> st;
            for (int j = i; j < i + minSize; j++) st.insert(s[j]);
            if (st.size() > maxLetters) continue;
            m[s.substr(i, minSize)]++;
        }
        int ans = 0;
        for (auto it = m.begin(); it != m.end(); it++) {
            ans = max(ans, it->second);
        }
        return ans;
    }
};