class Solution {
public:
    int countWords(vector<string>& words1, vector<string>& words2) {
        
        unordered_map<string, int> m1, m2;
        for (auto& w : words1) m1[w]++;
        for (auto& w : words2) m2[w]++;
        int res = 0;
        for (auto& p : m1) {
            if (p.second == 1 && m2[p.first] == 1) res++;
        }
        for (auto& p : m2) {
            if (p.second == 1 && m1[p.first] == 1) res++;
        }
        return res;
    }
};