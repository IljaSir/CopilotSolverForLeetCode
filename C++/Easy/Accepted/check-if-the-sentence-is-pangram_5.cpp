class Solution {
public:
    bool checkIfPangram(string sentence) {
        
        vector<int> v(26, 0);
        for (auto c : sentence) {
            v[c - 'a']++;
        }
        for (auto i : v) {
            if (i == 0) {
                return false;
            }
        }
        return true;
    }
};