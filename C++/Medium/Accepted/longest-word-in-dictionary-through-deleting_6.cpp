class Solution {
public:
    string findLongestWord(string s, vector<string>& dictionary) {
        
        int n = s.size();
        int m = dictionary.size();
        string res = "";
        for (int i = 0; i < m; i++) {
            int j = 0;
            int k = 0;
            while (j < n && k < dictionary[i].size()) {
                if (s[j] == dictionary[i][k]) {
                    k++;
                }
                j++;
            }
            if (k == dictionary[i].size()) {
                if (k > res.size() || (k == res.size() && dictionary[i] < res)) {
                    res = dictionary[i];
                }
            }
        }
        return res;
    }
};