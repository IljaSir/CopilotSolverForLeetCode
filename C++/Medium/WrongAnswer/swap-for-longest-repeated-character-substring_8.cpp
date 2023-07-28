class Solution {
public:
    int maxRepOpt1(string text) {
        
        int maxLen = 0;
        int n = text.size();
        vector<int> count(26, 0);
        for (int i = 0; i < n; i++) {
            count[text[i] - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            int left = 0;
            int right = 0;
            int k = 1;
            int curLen = 0;
            while (right < n) {
                if (text[right] == i + 'a' || k > 0) {
                    if (text[right] != i + 'a') {
                        k--;
                    }
                    right++;
                    curLen++;
                } else {
                    if (text[left] != i + 'a') {
                        k++;
                    }
                    left++;
                    curLen--;
                }
                if (curLen + k > count[i]) {
                    curLen--;
                    if (text[left] != i + 'a') {
                        k++;
                    }
                    left++;
                }
                maxLen = max(maxLen, curLen);
            }
        }
        return maxLen;
    }
};