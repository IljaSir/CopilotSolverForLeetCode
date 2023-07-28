class Solution {
public:
    string smallestEquivalentString(string s1, string s2, string baseStr) {
        
        vector<int> parent(26);
        for (int i = 0; i < 26; ++i) {
            parent[i] = i;
        }
        for (int i = 0; i < s1.length(); ++i) {
            unionSet(parent, s1[i] - 'a', s2[i] - 'a');
        }
        for (int i = 0; i < baseStr.length(); ++i) {
            baseStr[i] = find(parent, baseStr[i] - 'a') + 'a';
        }
        return baseStr;
    }
};