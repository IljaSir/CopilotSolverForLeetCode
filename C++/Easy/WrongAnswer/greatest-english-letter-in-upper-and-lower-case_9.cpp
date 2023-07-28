class Solution {
public:
    string greatestLetter(string s) {
        
        int n = s.size();
        if(n==0) return "";
        unordered_map<char, int> mp;
        for(int i=0;i<n;i++){
            mp[s[i]]++;
        }
        for(int i=0;i<n;i++){
            if(mp[s[i]]>0 && mp[toupper(s[i])]>0){
                return string(1, s[i]);
            }
        }
        return "";
    }
};