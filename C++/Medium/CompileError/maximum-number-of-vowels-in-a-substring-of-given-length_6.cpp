class Solution {
public:
    int maxVowels(string s, int k) {
        
        int n = s.size();
        int left = 0, right = 0;
        int res = 0;
        int count = 0;
        while (right < n) {
            if (isVowel(s[right])) {
                ++count;
            }
            ++right;
            if (right - left > k) {
                if (isVowel(s[left])) {
                    --count;
                }
                ++left;
            }
            res = max(res, count);
        }
        return res;
    }
};