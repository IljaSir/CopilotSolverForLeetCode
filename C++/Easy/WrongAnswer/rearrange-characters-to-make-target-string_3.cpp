class Solution {
public:
    int rearrangeCharacters(string s, string target) {
        
        int n = s.size();
        int m = target.size();
        vector<int> sCount(26, 0);
        vector<int> tCount(26, 0);
        for (char c : s) {
            sCount[c - 'a']++;
        }
        for (char c : target) {
            tCount[c - 'a']++;
        }
        int maxCount = 0;
        for (int i = 0; i < 26; ++i) {
            if (tCount[i] == 0) continue;
            if (sCount[i] == 0) return 0;
            maxCount = max(maxCount, sCount[i] / tCount[i]);
        }
        return maxCount;
    }
};