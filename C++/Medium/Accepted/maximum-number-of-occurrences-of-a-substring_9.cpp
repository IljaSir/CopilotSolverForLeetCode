class Solution {
public:
    int maxFreq(string s, int maxLetters, int minSize, int maxSize) {
        
        int n = s.size();
        if (n == 0) return 0;
        if (minSize > n) return 0;
        if (minSize == n) return 1;
        if (maxSize == n) return 1;
        if (maxSize < minSize) return 0;
        unordered_map<string, int> count;
        for (int i = 0; i <= n - minSize; ++i) {
            string sub = s.substr(i, minSize);
            unordered_set<char> letters;
            for (auto c : sub) {
                letters.insert(c);
            }
            if (letters.size() <= maxLetters) {
                ++count[sub];
            }
        }
        int maxCount = 0;
        for (auto p : count) {
            if (p.second > maxCount) {
                maxCount = p.second;
            }
        }
        return maxCount;
    }
};