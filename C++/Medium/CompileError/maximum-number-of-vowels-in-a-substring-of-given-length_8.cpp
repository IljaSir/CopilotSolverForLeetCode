class Solution {
public:
    int maxVowels(string s, int k) {
        
        int n = s.size();
        int i = 0, j = 0, cnt = 0;
        int res = 0;
        while (j < n) {
            if (isVowel(s[j])) {
                cnt++;
            }
            if (j - i + 1 == k) {
                res = max(res, cnt);
                if (isVowel(s[i])) {
                    cnt--;
                }
                i++;
            }
            j++;
        }
        return res;
    }
};