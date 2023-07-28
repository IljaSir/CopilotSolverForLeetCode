class Solution {
public:
    int maxProduct(vector<string>& words) {
        
        // sort the words in descending order of length
        sort(words.begin(), words.end(), [](string& a, string& b) {
            return a.length() > b.length();
        });
        // create a list of bitmasks for each word
        vector<int> masks(words.size());
        for (int i = 0; i < words.size(); i++) {
            for (char c : words[i]) {
                masks[i] |= 1 << (c - 'a');
            }
        }
        // check each pair of words
        int ans = 0;
        for (int i = 0; i < words.size(); i++) {
            if (words[i].length() * words[i].length() <= ans) {
                break;
            }
            for (int j = i + 1; j < words.size(); j++) {
                if ((masks[i] & masks[j]) == 0) {
                    ans = max(ans, int(words[i].length() * words[j].length()));
                    break;
                }
            }
        }
        return ans;
    }
};