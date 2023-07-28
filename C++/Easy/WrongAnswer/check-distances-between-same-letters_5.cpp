class Solution {
public:
    bool checkDistances(string s, vector<int>& distance) {
        
        int n = s.length();
        int cnt[26] = {0};
        for(int i = 0; i < n; ++i) {
            cnt[s[i] - 'a']++;
        }
        for(int i = 0; i < 26; ++i) {
            if(cnt[i] == 0) {
                distance[i] = 0;
            }
        }
        for(int i = 0; i < n; ++i) {
            int j = i + 1;
            int cnt = 0;
            while(j < n && s[j] != s[i]) {
                cnt++;
                j++;
            }
            if(j < n && cnt != distance[s[i] - 'a']) {
                return false;
            }
            i = j;
        }
        return true;
    }
};