class Solution {
public:
    bool checkIfCanBreak(string s1, string s2) {
        
        vector<int> count1(26, 0);
        vector<int> count2(26, 0);
        for (auto c: s1) {
            count1[c - 'a']++;
        }
        for (auto c: s2) {
            count2[c - 'a']++;
        }
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < 26; i++) {
            sum1 += count1[i];
            sum2 += count2[i];
            if (sum1 > sum2) {
                for (int j = i + 1; j < 26; j++) {
                    if (count2[j] > 0) {
                        return false;
                    }
                }
            }
            if (sum2 > sum1) {
                for (int j = i + 1; j < 26; j++) {
                    if (count1[j] > 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
};