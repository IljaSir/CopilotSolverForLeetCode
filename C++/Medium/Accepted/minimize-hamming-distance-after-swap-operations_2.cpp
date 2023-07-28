class Solution {
public:
    int minimumHammingDistance(vector<int>& source, vector<int>& target, vector<vector<int>>& allowedSwaps) {
        
        int n = source.size();
        vector<int> parent(n, 0);
        vector<int> size(n, 1);
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
        for (auto& swap : allowedSwaps) {
            int p1 = findParent(parent, swap[0]);
            int p2 = findParent(parent, swap[1]);
            if (p1 != p2) {
                if (size[p1] < size[p2]) {
                    parent[p1] = p2;
                    size[p2] += size[p1];
                } else {
                    parent[p2] = p1;
                    size[p1] += size[p2];
                }
            }
        }
        unordered_map<int, unordered_map<int, int>> count;
        for (int i = 0; i < n; ++i) {
            int p = findParent(parent, i);
            count[p][source[i]]++;
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int p = findParent(parent, i);
            if (count[p][target[i]] > 0) {
                count[p][target[i]]--;
            } else {
                ans++;
            }
        }
        return ans;
    }
    
    int findParent(vector<int>& parent, int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = findParent(parent, parent[i]);
    }
};