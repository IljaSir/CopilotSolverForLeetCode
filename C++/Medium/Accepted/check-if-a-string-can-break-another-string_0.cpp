class Solution {
public:
    bool checkIfCanBreak(string s1, string s2) {
        
        sort(s1.begin(), s1.end());
        sort(s2.begin(), s2.end());
        int n = s1.size();
        bool flag1 = true, flag2 = true;
        for (int i = 0; i < n; i++) {
            flag1 &= s1[i] >= s2[i];
            flag2 &= s1[i] <= s2[i];
        }
        return flag1 || flag2;
    }
};