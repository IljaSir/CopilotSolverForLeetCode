class Solution {
public:
    vector<int> longestRepeating(string s, string queryCharacters, vector<int>& queryIndices) {
        
        vector<int> result;
        for (int i = 0; i < queryCharacters.size(); i++) {
            int start = queryIndices[i];
            char c = queryCharacters[i];
            int j = start;
            while (j >= 0 && s[j] == c) {
                j--;
            }
            int k = start;
            while (k < s.size() && s[k] == c) {
                k++;
            }
            result.push_back(k - j - 1);
        }
        return result;
    }
};