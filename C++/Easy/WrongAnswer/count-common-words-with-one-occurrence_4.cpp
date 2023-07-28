class Solution {
public:
    int countWords(vector<string>& words1, vector<string>& words2) {
        
        unordered_map<string, int> m1;
        for (auto& w : words1) m1[w]++;
        unordered_map<string, int> m2;
        for (auto& w : words2) m2[w]++;
        int res = 0;
        for (auto& [k, v] : m1) {
            if (m2.find(k) == m2.end() && v == 1) res++;
        }
        for (auto& [k, v] : m2) {
            if (m1.find(k) == m1.end() && v == 1) res++;
        }
        return res;
    }
};