class Solution {
public:
    string frequencySort(string s) {
        
        vector<int> count(128, 0);
        for (char c : s) {
            count[c]++;
        }
        sort(s.begin(), s.end(), [&count](char c1, char c2) {
            return count[c1] > count[c2] || (count[c1] == count[c2] && c1 < c2);
        });
        return s;
    }
};