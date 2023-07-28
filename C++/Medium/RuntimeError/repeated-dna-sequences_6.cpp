class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        
        unordered_map<string, int> m;
        vector<string> res;
        for (int i = 0; i < s.size() - 9; ++i) {
            string dna = s.substr(i, 10);
            if (m.count(dna) && m[dna] == 1) {
                res.push_back(dna);
                m[dna]++;
            } else if (!m.count(dna)) {
                m[dna] = 1;
            }
        }
        return res;
    }
};