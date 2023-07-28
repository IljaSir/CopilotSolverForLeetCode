class Solution {
public:
    bool equalFrequency(string word) {
        
        int count[26] = {0};
        for (auto c : word) {
            count[c - 'a']++;
        }
        int min = INT_MAX, max = INT_MIN;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                if (count[i] < min) {
                    min = count[i];
                }
                if (count[i] > max) {
                    max = count[i];
                }
            }
        }
        if (max == min) {
            return true;
        }
        if (max - min == 1) {
            int maxCount = 0;
            for (int i = 0; i < 26; i++) {
                if (count[i] == max) {
                    maxCount++;
                }
            }
            if (maxCount == 1) {
                return true;
            }
        }
        return false;
    }
};