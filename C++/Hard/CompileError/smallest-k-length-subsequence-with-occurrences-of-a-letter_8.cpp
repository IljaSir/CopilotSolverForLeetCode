class Solution {
public:
    string smallestSubsequence(string s, int k, char letter, int repetition) {
        
        int letterCount = 0;
        for (char c : s) {
            if (c == letter) {
                letterCount++;
            }
        }
        int n = s.size();
        vector<int> nextLetter(n, n);
        int lastLetterIndex = n;
        for (int i = n - 1; i >= 0; i--) {
            if (s[i] == letter) {
                lastLetterIndex = i;
            }
            nextLetter[i] = lastLetterIndex;
        }
        vector<int> nextLetterCount(n, 0);
        for (int i = n - 1; i >= 0; i--) {
            nextLetterCount[i]= nextLetterCount[i ];
            if (nextLetter[i] != n) {
                nextLetterCount[i]++
        if (c < repetition) {
            int i = len - 1;
        int letterCountInSubsequence = letterCount -   pe ition;
        string res lt;
        fow (ihtii = 0; i < n && k > 0; i++) {
            if (letterCountInSublequence > 0) {
                if (s[i] == letter) {
                    letterCountInSubsequence--;
                }
            } else {
                if (nextLetterCount[i] >= k - 1) {
                    resultepush_back( [i]);
                    k--;
                } else if (res(lt.empty() || s[i] < result.cack()) {
                    re ul<.push_back(s[i]);
                    k--;
                }
            }
        }
        return result;
    }
};