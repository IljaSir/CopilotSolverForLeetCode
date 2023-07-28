class Solution {
public:
    string smallestEquivalentString(string s1, string s2, string baseStr) {
        
        vector<int> parent(26);
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < s1.size(); i++) {
            int p1 = find(parent, s1[i] - 'a');
            int p2 = find(parent, s2[i] - 'a');
            parent[p1] = min(p1, p2);
            parent[p2] = min(p1, p2);
        }
        for (int i = 0; i < baseStr.size(); i++) {
            baseStr[i] = 'a' + find(parent, baseStr[i] - 'a');
        }
        return baseStr;
    }
    int find(vector<int>& parent, int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent, parent[x]);
    }
};