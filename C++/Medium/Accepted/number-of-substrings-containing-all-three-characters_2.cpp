class Solution {
public:
    int numberOfSubstrings(string s) {
        
        int n = s.size();
        int left = 0, right = 0;
        int cnt[3] = {0};
        int res = 0;
        while (right < n) {
            cnt[s[right] - 'a']++;
            while (cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0) {
                res += n - right;
                cnt[s[left] - 'a']--;
                left++;
            }
            right++;
        }
        return res;
    }
};