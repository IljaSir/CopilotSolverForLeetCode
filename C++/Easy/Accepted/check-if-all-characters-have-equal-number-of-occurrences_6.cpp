class Solution {
public:
    bool areOccurrencesEqual(string s) {
        
        int n = s.length();
        vector<int> count(26,0);
        for(int i=0;i<n;i++){
            count[s[i]-'a']++;
        }
        int c = count[s[0]-'a'];
        for(int i=1;i<26;i++){
            if(count[i]!=0 && count[i]!=c){
                return false;
            }
        }
        return true;
    }
};