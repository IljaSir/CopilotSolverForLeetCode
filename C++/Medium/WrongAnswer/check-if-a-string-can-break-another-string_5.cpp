class Solution {
public:
    bool checkIfCanBreak(string s1, string s2) {
        
        int n = s1.size();
        vector<int> c1(26, 0), c2(26, 0);
        for (int i = 0; i < n; ++i) {
            ++c1[s1[i] - 'a'];
            ++c2[s2[i] - 'a'];
        }
        int j = 0;
        for (int i = 0; i < 26; ++i) {
            while (c1[i]--) {
                if (j >= 26 || c2[j] == 0) return false;
                --c2[j];
                ++j;
            }
        }
        j = 0;
        for (int i = 0; i < 26; ++i) {
            while (c2[i]--) {
                if (j >= 26 || c1[j] == 0) return false;
                --c1[j];
                ++j;
            }
        }
        return true;
    }
};