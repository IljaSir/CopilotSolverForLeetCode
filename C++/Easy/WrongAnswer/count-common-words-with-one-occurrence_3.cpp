class Solution {
public:
    int countWords(vector<string>& words1, vector<string>& words2) {
        
        unordered_map<string, int> m1, m2;
        for (string& w : words1) {
            ++m1[w];
        }
        for (string& w : words2) {
            ++m2[w];
        }
        int res = 0;
        for (auto& p : m1) {
            if (p.second == 1 && m2.count(p.first) == 0) {
                ++res;
            }
        }
        for (auto& p : m2) {
            if (p.second == 1 && m1.count(p.first) == 0) {
                ++res;
            }
        }
        return res;
    }
};