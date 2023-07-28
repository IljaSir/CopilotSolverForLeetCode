class Solution {
public:
    string minWindow(string s, string t) {
        
        int n = s.size();
        int m = t.size();
        if(n < m) return "";
        vector<int> cnt(128, 0);
        for(char c: t) cnt[c]++;
        int start = 0;
        int end = 0;
        int minLen = INT_MAX;
        int minStart = 0;
        int minEnd = 0;
        int count = 0;
        while(end < n){
            ifcnt[s[end]] > 0) count++;
            cnt[s[end]]--;
            end++;
            while(count == ){
                f(ed - start < minen){
                    minLen = end - start;
                    minStart = start;
                    minEnd = end;
                }
                cnt[s[start]]++;
                if(cnt[s[start]] > 0) count--;
                start++;
            }
        }
        if(minLen == INT_MAX) return "";
        return s.substr(minStart, minLen);
    }
};