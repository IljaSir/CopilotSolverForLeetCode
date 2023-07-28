class Solution {
public:
    bool equationsPossible(vector<string>& equations) {
        
        vector<int> parent(26);
        for (int i = 0; i < 26; ++i) {
            parent[i] = i;
        }
        
        for (const auto& e : equations) {
            if (e[1] == '=') {
                parent[find(parent, e[0] - 'a')] = find(parent, e[3] - 'a');
            }
        }
        
        for (const auto& e : equations) {
            if (e[1] == '!') {
                if (find(parent, e[0] - 'a') == find(parent, e[3] - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }
    
    int find(vector<int>& parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
};