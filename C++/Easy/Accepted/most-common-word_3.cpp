class Solution {
public:
    string mostCommonWord(string paragraph, vector<string>& banned) {
        
        unordered_map<string, int> map;
        for (int i = 0; i < paragraph.size(); i++) {
            if (isalpha(paragraph[i])) {
                int j = i;
                while (j < paragraph.size() && isalpha(paragraph[j])) {
                    paragraph[j] = tolower(paragraph[j]);
                    j++;
                }
                string word = paragraph.substr(i, j - i);
                if (find(banned.begin(), banned.end(), word) == banned.end()) {
                    map[word]++;
                }
                i = j;
            }
        }
        
        int max = 0;
        string result;
        for (auto it = map.begin(); it != map.end(); it++) {
            if (it->second > max) {
                max = it->second;
                result = it->first;
            }
        }
        return result;
    }
};