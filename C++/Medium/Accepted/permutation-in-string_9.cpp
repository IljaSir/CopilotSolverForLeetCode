class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        
        int n = s1.length();
        int m = s2.length();
        int i = 0, j = 0;
        vector<int> cnt(26, 0);
        for (int k = 0; k < n; k++) {
            cnt[s1[k] - 'a']++;
        }
        while (j < m) {
            cnt[s2[j] - 'a']--;
            if (j - i + 1 == n) {
                if (all_of(cnt.begin(), cnt.end(), [](int x) { return x == 0; })) {
                    return true;
                }
                cnt[s2[i] - 'a']++;
                i++;
            }
            j++;
        }
        return false;
    }
};