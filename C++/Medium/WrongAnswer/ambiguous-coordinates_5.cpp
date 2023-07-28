class Solution {
public:
    vector<string> ambiguousCoordinates(string s) {
        
        vector<string> result;
        for(int i=2;i<s.size()-1;i++){
            vector<string> left = getValidNumber(s.substr(1, i-1));
            vector<string> right = getValidNumber(s.substr(i, s.size()-1-i));
            for(auto l:left){
                for(auto r:right){
                    result.push_back("("+l+", "+r+")");
                }
            }
        }
        return result;
    }
    vector<string> getValidNumber(string s){
        vector<string> result;
        if(s.size()==1){
            result.push_back(s);
            return result;
        }
        if(s[0]!='0'){
            result.push_back(s);
        }
        for(int i=1;i<s.size();i++){
            if(s[i]=='0' && s[s.size()-1]=='0') continue;
            string temp = s.substr(0, i)+"."+s.substr(i);
            result.push_back(temp);
        }
        return result;
    }
};