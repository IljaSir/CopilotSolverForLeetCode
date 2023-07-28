class Solution {
public:
    vector<string> findOcurrences(string text, string first, string second) {
        
        vector<string> result;
        string word;
        istringstream iss(text);
        string prev1, prev2;
        while(iss >> word) {
            if (prev1 == first && prev2 == second) {
                result.push_back(word);
            }
            prev1 = prev2;
            prev2 = word;
        }
        return result;
    }
};