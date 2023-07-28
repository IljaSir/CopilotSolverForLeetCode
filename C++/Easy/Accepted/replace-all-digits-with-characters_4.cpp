class Solution {
public:
    string replaceDigits(string s) {
        
        string result;
        for(int i=0;i<s.length();i++){
            if(i%2==0){
                result.push_back(s[i]);
            }else{
                result.push_back(s[i-1]+(s[i]-'0'));
            }
        }
        return result;
    }
};