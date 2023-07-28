class Solution {
public:
    string smallestStringWithSwaps(string s, vector<vector<int>>& pairs) {
        
        vector<int> parent(s.size());
        iota(parent.begin(), parent.end(), 0);
        for (auto& pair : pairs) {
            int p0 = find(parent, pair[0]);
            int p1 = find(parent, pair[1]);
            parent[p0] = p1;
        }
        unordered_map<int, vector<int>> groups;
        for (int i = 0; i < s.size(); ++i) {
            groups[find(parent, i)].push_back(i);
        }
        for (auto& group : groups) {
            vector<char> chars;
            for (auto& i : group.second) {
                chars.push_back(s[i]);
            }
            sort(chars.begin(), chars.end());
            int j = 0;
            for (auto& i : group.second) {
                s[i] = chars[j++];
            }
        }
        return s;
    }
    
    int find(vector<int>& parent, int i) {
        while (parent[i] != i) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }
};