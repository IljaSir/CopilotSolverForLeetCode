class Solution {
public:
    bool makeEqual(vector<string>& words) {
        
        vector<int> count(26, 0);
        int n = words.size();
        for (int i = 0; i < n; i++) {
            for (auto c: words[i]) {
                count[c - 'a']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] % n != 0) {
                return false;
            }
        }
        return true;
    }
};