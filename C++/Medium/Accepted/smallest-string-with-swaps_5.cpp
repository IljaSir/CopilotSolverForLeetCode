class Solution {
public:
    string smallestStringWithSwaps(string s, vector<vector<int>>& pairs) {
        
        vector<int> root(s.size(), 0);
        for (int i = 0; i < s.size(); ++i) {
            root[i] = i;
        }
        for (auto& p : pairs) {
            int x = find(root, p[0]);
            int y = find(root, p[1]);
            root[x] = y;
        }
        unordered_map<int, priority_queue<char, vector<char>, greater<char>>> mp;
        for (int i = 0; i < s.size(); ++i) {
            int x = find(root, i);
            mp[x].push(s[i]);
        }
        for (int i = 0; i < s.size(); ++i) {
            int x = find(root, i);
            s[i] = mp[x].top();
            mp[x].pop();
        }
        return s;
    }
    int find(vector<int>& root, int x) {
        if (root[x] == x) {
            return x;
        }
        return root[x] = find(root, root[x]);
    }
};