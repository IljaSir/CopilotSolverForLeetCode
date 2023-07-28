class Solution {
public:
    bool makeEqual(vector<string>& words) {
        
        int n = words.size();
        vector<int> freq(26, 0);
        for (auto word : words) {
            for (auto c : word) {
                freq[c - 'a']++;
            }
        }
        for (auto f : freq) {
            if (f % n != 0) return false;
        }
        return true;
    }
};