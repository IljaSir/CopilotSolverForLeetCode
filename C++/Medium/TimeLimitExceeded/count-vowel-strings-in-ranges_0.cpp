class Solution {
public:
    vector<int> vowelStrings(vector<string>& words, vector<vector<int>>& queries) {
        
        vector<int> ans;
        for (auto& query : queries) {
            int start = query[0];
            int end = query[1];
            int count = 0;
            for (int i = start; i <= end; i++) {
                string word = words[i];
                if (word[0] == 'a' || word[0] == 'e' || word[0] == 'i' || word[0] == 'o' || word[0] == 'u') {
                    if (word[word.length() - 1] == 'a' || word[word.length() - 1] == 'e' || word[word.length() - 1] == 'i' || word[word.length() - 1] == 'o' || word[word.length() - 1] == 'u') {
                        count++;
                    }
                }
            }
            ans.push_back(count);
        }
        return ans;
    }
};