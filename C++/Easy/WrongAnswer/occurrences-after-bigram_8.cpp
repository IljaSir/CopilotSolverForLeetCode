class Solution {
public:
    vector<string> findOcurrences(string text, string first, string second) {
        
        vector<string> res;
        string str = first + " " + second;
        for (int i=0; i<text.size(); i++) {
            int j = text.find(str, i);
            if (j == string::npos) break;
            int k = text.find(' ', j+str.size());
            if (k == string::npos) break;
            res.push_back(text.substr(j+str.size(), k-j-str.size()));
            i = k;
        }
        return res;
    }
};