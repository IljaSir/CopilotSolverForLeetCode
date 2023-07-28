class Solution {
public:
    vector<string> findOcurrences(string text, string first, string second) {
        
        vector<string> result;
        string word;
        istringstream iss(text);
        while (iss >> word) {
            if (word == first) {
                if (iss >> word) {
                    if (word == second) {
                        if (iss >> word) {
                            result.push_back(word);
                        }
                    }
                }
            }
        }
        return result;
    }
};