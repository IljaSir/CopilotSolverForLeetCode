class Solution {
public:
    int countWords(vector<string>& words1, vector<string>& words2) {
        
        unordered_map<string, int> m1, m2;
        for (string& s : words1) {
            m1[s]++;
        }
        for (string& s : words2) {
            m2[s]++;
        }
        int res = 0;
        for (auto& p : m1) {
            if (p.second == 1 && m2.find(p.first) != m2.end() && m2[p.first] == 1) {
                res++;
            }
        }
        for (auto& p : m2) {
            if (p.second == 1 && m1.find(p.first) != m1.end() && m1[p.first] == 1) {
                res++;
            }
        }
        return res;
    }
};