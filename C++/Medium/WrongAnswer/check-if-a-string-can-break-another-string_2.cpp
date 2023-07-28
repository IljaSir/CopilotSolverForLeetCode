class Solution {
public:
    bool checkIfCanBreak(string s1, string s2) {
        
        vector<int> v1(26, 0), v2(26, 0);
        for (char c : s1) v1[c - 'a']++;
        for (char c : s2) v2[c - 'a']++;
        int cnt1 = 0, cnt2 = 0;
        bool flag = false;
        for (int i = 0; i < 26; i++) {
            cnt1 += v1[i];
            cnt2 += v2[i];
            if (cnt1 > cnt2) {
                if (flag) return false;
                flag = true;
            } else if (cnt2 > cnt1) {
                if (!flag) return false;
                flag = false;
            }
        }
        return true;
    }
};