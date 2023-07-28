class Solution {
public:
    bool hasAllCodes(string s, int k) {
        
        int n = s.size();
        if (n < k) return false;
        vector<bool> seen(1 << k, false);
        int allOne = (1 << k) - 1;
        int hash = 0;
        for (int i = 0; i < k; ++i) {
            hash = (hash << 1) + (s[i] - '0');
        }
        seen[hash] = true;
        for (int i = k; i < n; ++i) {
            hash = ((hash << 1) & allOne) + (s[i] - '0');
            seen[hash] = true;
        }
        for (bool v : seen) {
            if (!v) return false;
        }
        return true;
    }
};