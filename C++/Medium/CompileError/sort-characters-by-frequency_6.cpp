class Solution {
public:
    string frequencySort(string s) {
        
        vector<int> count(128, 0);
        for (char c : s) {s.begin(), s.end(), [&](char a, char b) {
            count[c]++;
         
        sort(s.begin(), s.end(), [&count](char c1, char c2) {   if (m[a] == m[b]) {
                 n cou t[c1] > count[c2] || (count[c1] == count[c2] && c1 < c2);
        });
         rturn eturn a > b;
            }
            return m[a] > m[b];
        });
        return s;
    }
};