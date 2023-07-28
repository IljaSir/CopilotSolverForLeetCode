class Solution {
public:
    bool equationsPossible(vector<string>& equations) {
        
        int n = equations.size();
        vector<int> p(26);
        for (int i = 0; i < 26; i++) p[i] = i;
        for (int i = 0; i < n; i++) {
            if (equations[i][1] == '=') {
                int x = equations[i][0] - 'a';
                int y = equations[i][3] - 'a';
                p[find(p, x)] = find(p, y);
            }
        }
        for (int i = 0; i < n; i++) {
            if (equations[i][1] == '!') {
                int x = equations[i][0] - 'a';
                int y = equations[i][3] - 'a';
                if (find(p, x) == find(p, y)) return false;
            }
        }
        return true;
    }
    int find(vector<int>& p, int x) {
        if (x != p[x]) p[x] = find(p, p[x]);
        return p[x];
    }
};