class Solution {
public:
    string findLongestWord(string s, vector<string>& dictionary) {
        
        sort(dictionary.begin(), dictionary.end(), [](const string& a, const string& b) {
            if (a.size() == b.size()) return a < b;
            return a.size() > b.size();
        });
        for (auto& word : dictionary) {
            if (isSubsequence(word, s)) return word;
        }
        return "";
    }
};