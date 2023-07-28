class Solution {
public:
    bool equalFrequency(string word) {
        
        int freq[26] = {0};
        for (auto c : word) {
            freq[c - 'a']++;
        }
        int min = INT_MAX;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0 && freq[i] < min) {
                min = freq[i];
            }
        }
        int max = INT_MIN;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > max) {
                max = freq[i];
            }
        }
        if (max == min) {
            return true;
        }
        if (max == min + 1) {
            for (int i = 0; i < 26; i++) {
                if (freq[i] == max) {
                    freq[i]--;
                    break;
                }
            }
            min = INT_MAX;
            for (int i = 0; i < 26; i++) {
                if (freq[i] > 0 && freq[i] < min) {
                    min = freq[i];
                }
            }
            if (max == min) {
                return true;
            }
        }
        return false;
    }
};