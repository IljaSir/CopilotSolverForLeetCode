class Solution {
public:
    string findReplaceString(string s, vector<int>& indices, vector<string>& sources, vector<string>& targets) {
        
        string result;
        int i = 0;
        while (i < s.length()) {
            int j = 0;
            while (j < indices.size()) {
                if (i == indices[j]) {
                    if (s.substr(i, sources[j].length()) == sources[j]) {
                        result += targets[j];
                        i += sources[j].length();
                        break;
                    } else {
                        result += s[i];
                        i++;
                        break;
                    }
                } else {
                    j++;
                }
            }
            if (j == indices.size()) {
                result += s[i];
                i++;
            }
        }
        return result;
    }
};