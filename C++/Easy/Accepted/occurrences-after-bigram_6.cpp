class Solution {
public:
    vector<string> findOcurrences(string text, string first, string second) {
        
        vector<string> v;
        istringstream iss(text);
        string w1, w2, w3;
        while (iss >> w1) {
            if (w2.empty()) {
                w2 = w1;
                continue;
            }
            if (w3.empty()) {
                w3 = w1;
                continue;
            }
            if (w2 == first && w3 == second) {
                v.push_back(w1);
            }
            w2 = w3;
            w3 = w1;
        }
        return v;
    }
};