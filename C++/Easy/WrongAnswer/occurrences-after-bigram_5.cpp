class Solution {
public:
    vector<string> findOcurrences(string text, string first, string second) {
        
        vector<string> ret;
        string temp;
        stringstream ss(text);
        while(ss >> temp) {
            if (temp == first) {
                if (ss >> temp) {
                    if (temp == second) {
                        if (ss >> temp) {
                            ret.push_back(temp);
                        }
                    }
                }
            }
        }
        return ret;
    }
};