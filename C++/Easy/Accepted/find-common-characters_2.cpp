class Solution {
public:
    vector<string> commonChars(vector<string>& words) {
        
        vector<string> result;
        vector<int> count(26, 0);
        for (char ch : words[0]) {
            count[ch - 'a']++;
        }
        for (int i = 1; i < words.size(); i++) {
            vector<int> countTemp(26, 0);
            for (char ch : words[i]) {
                countTemp[ch - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                count[i] = min(count[i], countTemp[i]);
            }
        }
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                result.push_back(string(1, 'a' + i));
                count[i]--;
            }
        }
        return result;
    }
};