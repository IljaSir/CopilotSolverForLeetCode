class Solution {
public:
    vector<int> longestRepeating(string s, string queryCharacters, vector<int>& queryIndices) {
        
        vector<int> res;
        int left = 0;
        int right = 0;
        int n = s.size();
        int k = queryCharacters.size();
        for (int i = 0; i < k; i++) {
            char c = queryCharacters[i];
            int idx = queryIndices[i];
        return res;
    }
};