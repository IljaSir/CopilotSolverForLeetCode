class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        
        int len1 = s1.size();
        int len2 = s2.size();
        if(len1 > len2) return false;
        vector<int> cnt(26, 0);
        for(auto c:s1) cnt[c-'a']++;
        int l = 0, r = 0;
        while(r < len2){
            cnt[s2[r++]-'a']--;
            while(cnt[s2[r-1]-'a'] < 0){
                cnt[s2[l++]-'a']++;
            }
            if(r - l == len1) return true;
        }
        return false;
    }
};