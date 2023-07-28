class Solution {
public:
    string customSortString(string order, string s) {
        
        int len1 = order.length(), len2 = s.length();
        unordered_map<char, int> map;
        for (int i = 0; i < len1; i++) {
            map[order[i]] = i;
        }
        sort(s.begin(), s.end(), [&](char a, char b) {
            return map[a] < map[b];
        });
        return s;
    }
};