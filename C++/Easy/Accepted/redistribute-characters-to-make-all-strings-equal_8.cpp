class Solution {
public:
    bool makeEqual(vector<string>& words) {
        
        int n = words.size();
        if (n == 1) return true;
        unordered_map<char, int> m;
        for (string& s: words) {
            for (char c: s) {
                m[c]++;
            }
        }
        for (auto& [c, cnt]: m) {
            if (cnt % n != 0) return false;
        }
        return true;
    }
};