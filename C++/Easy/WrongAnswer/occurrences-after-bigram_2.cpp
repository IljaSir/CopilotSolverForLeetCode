class Solution {
public:
    vector<string> findOcurrences(string text, string first, string second) {
        
        vector<string> res;
        istringstream iss(text);
        string s1, s2;
        while (iss >> s1) {
            if (s1 == first && s2 == second) {
                string s3;
                iss >> s3;
                res.push_back(s3);
            }
            s2 = s1;
        }
        return res;
    }
};