class Solution {
public:
    vector<string> fullJustify(vector<string>& words, int maxWidth) {
        
        vector<string> res;
        int n = words.size();
        int left = 0;
        while (left < n) {
            int right = left;
            int sumLen = 0;
            while (right < n && sumLen + words[right].length() + right - left <= maxWidth) {
                sumLen += words[right].length();
                right++;
            }
            string s = words[left];
            int numWords = right - left;
            int numSpaces = maxWidth - sumLen;
            if (right == n || numWords == 1) {
                for (int i = left + 1; i < right; i++) {
                    s += " " + words[i];
                }
                s += string(numSpaces - numWords + 1, ' ');
            } else {
                int avgSpaces = numSpaces / (numWords - 1);
                int extraSpaces = numSpaces % (numWords - 1);
                for (int i = left + 1; i < right; i++) {
                    s += string(avgSpaces + (i - left <= extraSpaces ? 1 : 0), ' ') + words[i];
                }
            }
            res.push_back(s);
            left = right;
        }
        return res;
    }
};