class Solution {
public:
    bool canConstruct(string s, int k) {
        
        if (s.size() < k) return false;
        if (s.size() == k) return true;
        vector<int> count(26, 0);
        for (auto ch : s) {
            count[ch - 'a']++;
        }
        int odd = 0;
        for (auto c : count) {
            if (c & 1) odd++;
        }
        return odd <= k;
    }
};