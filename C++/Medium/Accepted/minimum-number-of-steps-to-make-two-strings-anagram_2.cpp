class Solution {
public:
    int minSteps(string s, string t) {
        
        vector<int> vec(26, 0);
        for (char c : s) {
            vec[c - 'a']++;
        }
        for (char c : t) {
            vec[c - 'a']--;
        }
        int res = 0;
        for (int i : vec) {
            res += abs(i);
        }
        return res / 2;
    }
};