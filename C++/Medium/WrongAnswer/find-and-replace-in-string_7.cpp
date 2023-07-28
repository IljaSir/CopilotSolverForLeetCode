class Solution {
public:
    string findReplaceString(string s, vector<int>& indices, vector<string>& sources, vector<string>& targets) {
        
        string res = "";
        int i = 0;
        int n = indices.size();
        int j = 0;
        while(i < s.size()) {
            if(j < n && i == indices[j]) {
                if(s.substr(i, sources[j].size()) == sources[j]) {
                    res += targets[j];
                    i += sources[j].size();
                } else {
                    res += s[i];
                    i++;
                }
                j++;
            } else {
                res += s[i];
                i++;
            }
        }
        return res;
    }
};