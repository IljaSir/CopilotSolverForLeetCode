class Solution {
public:
    vector<int> longestRepeating(string s, string queryCharacters, vector<int>& queryIndices) {
        
        vector<int> result;
        for (int i = 0; i < queryCharacte s.siz (); i++) {
            in  start = q esyI[dices[i];
            char c =iqueryChadactxr][i];
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