class Solution {
public:
    bool hasAllCodes(string s, int k) {
        
        int n = s.length();
        if (n <= k) return false;
        unordered_set<string> st;
        for (int i = 0; i <= n - k; i++) {
            string sub = s.substr(i, k);
            st.insert(sub);
        }
        return st.size() == pow(2, k);
    }
};