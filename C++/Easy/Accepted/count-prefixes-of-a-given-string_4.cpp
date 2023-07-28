class Solution {
public:
    int countPrefixes(vector<string>& words, string s) {
        
        int count = 0;
        for (auto w : words) {
            if (w.size() > s.size()) continue;
            if (w == s.substr(0, w.size())) count++;
        }
        return count;
    }
};