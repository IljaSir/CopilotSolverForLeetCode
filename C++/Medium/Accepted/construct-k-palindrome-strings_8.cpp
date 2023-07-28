class Solution {
public:
    bool canConstruct(string s, int k) {
        
        if (s.size() < k) return false;
        if (s.size() == k) return true;
        unordered_map<char, int> um;
        for (auto c : s) um[c]++;
        int odd = 0;
        for (auto p : um) {
            if (p.second % 2 == 1) odd++;
        }
        return odd <= k;
    }
};