class Solution {
public:
    vector<string> findOcurrences(string text, string first, string second) {
        
        vector<string> res;
        string word;
        istringstream iss(text);
        string f, s;
        while (iss >> word) {
            if (f == first && s == second) {
                res.push_back(word);
            }
            f = s;
            s = word;
        }
        return res;
    }
};