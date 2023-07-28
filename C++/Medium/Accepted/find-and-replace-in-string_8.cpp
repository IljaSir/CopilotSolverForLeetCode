class Solution {
public:
    string findReplaceString(string s, vector<int>& indices, vector<string>& sources, vector<string>& targets) {
        
        string result = "";
        int i = 0;
        while(i < s.size()){
            int j = 0;
            for(; j < indices.size(); ++j){
                if(indices[j] == i){
                    if(s.substr(i, sources[j].size()) == sources[j]){
                        result += targets[j];
                        i += sources[j].size();
                        break;
                    }
                }
            }
            if(j == indices.size()){
                result += s[i];
                ++i;
            }
        }
        return result;
    }
};