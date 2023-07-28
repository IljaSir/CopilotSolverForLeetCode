class Solution {
public:
    string mostCommonWord(string paragraph, vector<string>& banned) {
        
        unordered_set<string> banned_words(banned.begin(), banned.end());
        unordered_map<string, int> counter;
        for (auto& ch : paragraph) {
            ch = isalpha(ch) ? tolower(ch) : ' ';
        }
        istringstream iss(paragraph);
        string word;
        while (iss >> word) {
            if (banned_words.find(word) == banned_words.end()) {
                ++counter[word];
            }
        }
        return max_element(counter.begin(), counter.end(), [](const auto& lhs, const auto& rhs) {
            return lhs.second < rhs.second;
        })->first;
    }
};