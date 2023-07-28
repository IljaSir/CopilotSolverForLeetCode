class Solution {
public:
    vector<string> findOcurrences(string text, string first, string second) {
        
        vector<string> res;
        string word;
        istringstream iss(text);
        string firstWord = "";
        string secondWord = "";
        while(iss >> word) {
            if(firstWord == first && secondWord == second) {
                res.push_back(word);
            }
            firstWord = secondWord;
            secondWord = word;
        }
        return res;
    }
};