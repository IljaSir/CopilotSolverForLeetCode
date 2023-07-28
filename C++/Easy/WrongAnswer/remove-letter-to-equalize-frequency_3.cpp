class Solution {
public:
    bool equalFrequency(string word) {
        
        int freq[26] = {0};
        for (char ch : word) {
            freq[ch - 'a']++;
        }
        int count[100001] = {0};
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                count[freq[i]]++;
            }
        }
        int odd = 0;
        for (int i = 0; i < 100001; i++) {
            if (count[i] != 0) {
                if (count[i] % 2 == 1) {
                    odd++;
                }
            }
        }
        if (odd == 1) {
            return true;
        }
        if (odd > 1) {
            return false;
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 1) {
                return true;
            }
        }
        return false;
    }
};