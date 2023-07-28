class Solution {
public:
    bool checkIfCanBreak(string s1, string s2) {
        
        int n = s1.size();
        vector<int> v1(26, 0);
        vector<int> v2(26, 0);
        for (int i = 0; i < n; ++i) {
            v1[s1[i] - 'a']++;
            v2[s2[i] - 'a']++;
        }
        int cnt = 0;
        for (int i = 0; i < 26; ++i) {
            cnt += v1[i];
            if (cnt >= n) return true;
            cnt -= v2[i];
            if (cnt <= 0) return false;
        }
        return true;
    }
};