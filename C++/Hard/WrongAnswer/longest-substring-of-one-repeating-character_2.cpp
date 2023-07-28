class Solution {
public:
    vector<int> longestRepeating(string s, string queryCharacters, vector<int>& queryIndices) {
        
        vector<int> res;
        for (int i = 0; i < queryCharacters.size(); i++) {
            int index = queryIndices[i];
            char ch = queryCharacters[i];
            int left = index, right = index, len = 0;
            while (left >= 0 && s[left] == ch) {
                left--;
                len++;
            }
            while (right < s.size() && s[right] == ch) {
                right++;
                len++;
            }
            res.push_back(len);
        }
        return res;
    }
};