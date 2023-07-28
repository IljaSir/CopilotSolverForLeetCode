class Solution {
public:
    string makeFancyString(string s) {
        
        int n = s.size();
        string ans = "";
        int i = 0;
        while(i < n) {
            int j = i;
            while(j < n && s[i] == s[j]) {
                j++;
            }
            int count = j - i;
            int len = min(count, 2);
            for(int k = 0; k < len; k++) {
                ans += s[i];
            }
            i = j;
        }
        return ans;
    }
};