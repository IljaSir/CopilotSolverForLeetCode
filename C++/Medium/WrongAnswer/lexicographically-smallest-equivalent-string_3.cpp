class Solution {
public:
    string smallestEquivalentString(string s1, string s2, string baseStr) {
        
        vector<int> parent(26);
        iota(parent.begin(), parent.end(), 0);
        function<int(int)> find = [&](int x) {
            return parent[x] == x ? x : parent[x] = find(parent[x]);
        };
        for (int i = 0; i < s1.size(); ++i) {
            parent[find(s1[i] - 'a')] = find(s2[i] - 'a');
        }
        for (int i = 0; i < baseStr.size(); ++i) {
            baseStr[i] = find(baseStr[i] - 'a') + 'a';
        }
        return baseStr;
    }
};