class Solution {
public:
    int minDeletions(string s) {
        
        vector<int> freq(26, 0);
        for (char c : s) {
            freq[c - 'a']++;
        }
        int ret = 0;
        set<int> used;
        for (int f : freq) {
            while (f > 0 && used.count(f)) {
                f--;
                ret++;
            }
            used.insert(f);
        }
        return ret;
    }
};