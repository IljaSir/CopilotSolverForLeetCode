class Solution {
public:
    char findTheDifference(string s, string t) {
        
        int len = s.length();
        int sum1 = 0;
        int sum2 = 0;
        for(int i=0; i<len; i++){
            sum1 += s[i];
            sum2 += t[i];
        }
        sum2 += t[len];
        return (char)(sum2 - sum1);
    }
};