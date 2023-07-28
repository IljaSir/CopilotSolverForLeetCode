class Solution {
public:
    string findReplaceString(string s, vector<int>& indices, vector<string>& sources, vector<string>& targets) {
        
        string res = "";
        int i = 0;
        int j = 0;
        int k = 0;
        int n = s.length();
        int m = indices.size();
        while (i < n) {
            if (j < m && i == indices[j]) {
                if (s.substr(i, sources[j].length()) == sources[j]) {
                    res += targets[j];
                    i += sources[j].length();
                    j++;
                } else {
                    res += s[i];
                    i++;
                }
            } else {
                res += s[i];
                i++;
            }
        }
        return res;
    }
};