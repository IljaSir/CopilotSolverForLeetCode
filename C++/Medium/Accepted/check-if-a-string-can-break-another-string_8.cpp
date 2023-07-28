class Solution {
public:
    bool checkIfCanBreak(string s1, string s2) {
        
        int n = s1.size();
        sort(s1.begin(), s1.end());
        sort(s2.begin(), s2.end());
        int i = 0;
        for(; i < n; ++i){
            if(s1[i] < s2[i]) break;
        }
        if(i == n) return true;
        i = 0;
        for(; i < n; ++i){
            if(s1[i] > s2[i]) break;
        }
        return i == n;
    }
};