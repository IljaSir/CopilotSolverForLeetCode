class Solution {
public:
    int countHomogenous(string s) {
        
        int res = 0;
        int count = 1;
        for (int i = 1; i < s.size(); ++i) {
            if (s[i] == s[i-1]) {
                count++;
            } else {
                res = (res + (count+1)*count/2) % 1000000007;
                count = 1;
            }
        }
        res = (res + (count+1)*count/2) % 1000000007;
        return res;
    }
};