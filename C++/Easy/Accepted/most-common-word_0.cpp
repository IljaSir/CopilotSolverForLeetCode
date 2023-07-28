class Solution {
public:
    string mostCommonWord(string paragraph, vector<string>& banned) {
        
        unordered_map<string, int> count;
        for (auto &ch: paragraph) ch = isalpha(ch) ? tolower(ch) : ' ';
        istringstream iss(paragraph);
        string word;
        while (iss >> word) count[word]++;
        for (auto &b: banned) count.erase(b);
        auto cmp = [](const pair<string, int> &a, const pair<string, int> &b) {
            return a.second < b.second;
        };
        return max_element(count.begin(), count.end(), cmp)->first;
    }
};