class Solution {
public:
    vector<bool> friendRequests(int n, vector<vector<int>>& restrictions, vector<vector<int>>& requests) {
        
        vector<bool> result(requests.size(), true);
        vector<int> parent(n);
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
        for (auto& restriction : restrictions) {
            int p1 = find(parent, restriction[0]);
            int p2 = find(parent, restriction[1]);
            if (p1 != p2) {
                parent[p1] = p2;
            }
        }
        for (int i = 0; i < requests.size(); ++i) {
            int p1 = find(parent, requests[i][0]);
            int p2 = find(parent, requests[i][1]);
            if (p1 == p2) {
                result[i] = false;
            }
        }
        return result;
    }
};