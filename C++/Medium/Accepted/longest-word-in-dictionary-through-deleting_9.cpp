class Solution {
public:
    string findLongestWord(string s, vector<string>& dictionary) {
        
        int i, j, k, n = s.size(), m = dictionary.size();
        string ans = "";
        for (i = 0; i < m; i++) {
            j = 0;
            k = 0;
            while (j < n && k < dictionary[i].size()) {
                if (s[j] == dictionary[i][k]) {
                    j++;
                    k++;
                } else {
                    j++;
                }
            }
            if (k == dictionary[i].size()) {
                if (ans.size() < dictionary[i].size()) {
                    ans = dictionary[i];
                } else if (ans.size() == dictionary[i].size()) {
                    ans = ans < dictionary[i] ? ans : dictionary[i];
                }
            }
        }
        return ans;
    }
};