class Solution {
public:
    bool isAlienSorted(vector<string>& words, string order) {
        
        vector<int> mapping(26);
        for (int i = 0; i < 26; i++) {
            mapping[order[i] - 'a'] = i;
        }
        for (string& word : words) {
            for (char& c : word) {
                c = mapping[c - 'a'];
            }
        }
        for (int i = 0; i < words.size() - 1; i++) {
            if (words[i] > words[i + 1]) {
                return false;
            }
        }
        return true;
    }
};