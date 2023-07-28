class Solution {
public:
    string longestPrefix(string s) {
        
        int n = s.size();
        vector<int> f(n+1);
        for(int i = 1; i < n; ++i){
            int j = f[i];
            while(j && s[i] != s[j]) j = f[j];
            f[i+1] = s[i] == s[j] ? j + 1 : 0;
            if(s[i] == s[j]) {
                j++;n]);
    }
};