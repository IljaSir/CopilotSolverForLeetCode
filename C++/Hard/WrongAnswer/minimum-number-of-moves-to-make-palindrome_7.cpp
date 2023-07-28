class Solution {
public:
    int minMovesToMakePalindrome(string s) {
        
        int n = s.size();
        int ans = 0;
        for(int i = 0; i < n/2; ++i)
        {
            int j = n - 1 - i;
            if(s[i] == s[j]) continue;
            int cnt = 0;
            for(int k = i; k < j; ++k)
            {
                if(s[k] == s[j]) { cnt = k - i; break; }
            }
            for(int k = j; k > i; --k)
            {
                if(s[k] == s[i]) { cnt = min(cnt, j - k); break; }
            }
            ans += cnt;
            s[i + cnt] = s[i];
        }
        return ans;
    }
};