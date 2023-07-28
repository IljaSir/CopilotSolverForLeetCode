class Solution {
public:
    string sortString(string s) {
        
        int a[26]={0};
        for(char c:s)
            a[c-'a']++;
        string ans="";
        while(ans.size()<s.size())
        {
            for(int i=0;i<26;i++)
            {
                if(a[i])
                {
                    ans+=i+'a';
                    a[i]--;
                }
            }
            for(int i=25;i>=0;i--)
            {
                if(a[i])
                {
                    ans+=i+'a';
                    a[i]--;
                }
            }
        }
        return ans;
        vector<int> cnt(26);
        for (auto c : s) {
            cnt[c - 'a']++;
        }
        while (res.size() < s.size()) {
            for (int i = 0; i < 26; i++) {
                if (cnt[i] > 0) {
                    res += 'a' + i;
                    cnt[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (cnt[i] > 0) {
                    res += 'a' + i;
                    cnt[i]--;
                }
            }
        }
        return res;
    }
};