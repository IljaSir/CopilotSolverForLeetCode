class Solution {
public:
    string addSpaces(string s, vector<int>& spaces) {
        
        string res;
        int i=0;
        for(auto space:spaces){
            res+=s.substr(i,space-i);
            res+=' ';
            i=space;
        }
        res+=s.substr(i);
        return res;
    }
};