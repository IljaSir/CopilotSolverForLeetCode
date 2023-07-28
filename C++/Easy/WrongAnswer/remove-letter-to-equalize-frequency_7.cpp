class Solution {
public:
    bool equalFrequency(string word) {
        
        int count[26] = {0};
        for (char c : word) {
            count[c - 'a']++;
        }
        int maxCount = 0;
        int minCount = 0x7fffffff;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                maxCount = max(maxCount, count[i]);
                minCount = min(minCount, count[i]);
            }
        }
        if (maxCount == minCount) {
            return true;
        }
        if (maxCount - minCount == 1) {
            int maxCountCount = 0;
            int minCountCount = 0;
            for (int i = 0; i < 26; i++) {
                if (count[i] == maxCount) {
                    maxCountCount++;
                }
                if (count[i] == minCount) {
                    minCountCount++;
                }
            }
            if (maxCountCount == 1) {
                return true;
            }
            if (minCountCount == 1) {
                return true;
            }
        }
        return false;
    }
};