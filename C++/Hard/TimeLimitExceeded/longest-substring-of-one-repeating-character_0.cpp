class Solution {
public:
    vector<int> longestRepeating(string s, string queryCharacters, vector<int>& queryIndices) {
        
        vector<int> result;
        for (int i = 0; i < queryCharacters.size(); ++i) {
            char c = queryCharacters[i];
            int index = queryIndices[i];
            s[index] = c;
            result.push_back(longestRepeating(s));
        }
        return result;
    }
    int longestRepeating(string s) {
        int result = 0;
        int count = 0;
        char prev = s[0];
        for (int i = 0; i < s.size(); ++i) {
            if (s[i] == prev) {
                count++;
            } else {
                count = 1;
                prev = s[i];
            }
            result = max(result, count);
        }
        return result;
    }
};