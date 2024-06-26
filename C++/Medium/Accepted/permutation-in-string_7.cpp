class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        
        int n = s1.size();
        int m = s2.size();
        if (n > m) return false;
        vector<int> cnt(26);
        for (int i = 0; i < n; i ++) {
            cnt[s1[i] - 'a'] ++;
            cnt[s2[i] - 'a'] --;
        }
        if (all_of(cnt.begin(), cnt.end(), [](int x){return x == 0;})) return true;
        for (int i = n; i < m; i ++) {
            cnt[s2[i] - 'a'] --;
            cnt[s2[i - n] - 'a'] ++;
            if (all_of(cnt.begin(), cnt.end(), [](int x){return x == 0;})) return true;
        }
        return false;
    }
};