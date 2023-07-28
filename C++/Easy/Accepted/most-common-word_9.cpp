class Solution {
public:
    string mostCommonWord(string paragraph, vector<string>& banned) {
        
        string result;
        unordered_map<string, int> map;
        for (char& c : paragraph) c = isalpha(c) ? tolower(c) : ' ';
        istringstream iss(paragraph);
        string word;
        while (iss >> word) map[word]++;
        for (auto& p : map) {
            if (find(banned.begin(), banned.end(), p.first) == banned.end() && (result.empty() || p.second > map[result])) {
                result = p.first;
            }
        }
        return result;
    }
};