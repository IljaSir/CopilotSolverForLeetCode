class Solution {
public:
    bool areOccurrencesEqual(string s) {
        
        int count[26]={0};
        for(int i=0;i<s.length();i++){
            count[s[i]-'a']++;
        }
        int c=count[s[0]-'a'];
        for(int i=1;i<26;i++){
            if(count[i]!=0 && count[i]!=c){
                return false;
            }
        }
        return true;
    }
};