class Solution {
public:
    int closestMeetingNode(vector<int>& edges, int node1, int node2) {
        
        int n = edges.size();
        vector<int> dist1(n, INT_MAX);
        vector<int> dist2(n, INT_MAX);
        dist1[node1] = 0;
        dist2[node2] = 0;
        for (int i = 0; i < n; i++) {
            if (edges[i] != -1) {
                if (dist1[i] != INT_MAX) {
                    dist1[edges[i]] = min(dist1[edges[i]], dist1[i] + 1);
                }
                if (dist2[i] != INT_MAX) {
                    dist2[edges[i]] = min(dist2[edges[i]], dist2[i] + 1);
                }
            }
        }
        int ans = -1;
        int minDist = INT_MAX;
        for (int i = 0; i < n; i++) {
            if (dist1[i] != INT_MAX && dist2[i] != INT_MAX) {
                if (dist1[i] + dist2[i] < minDist) {
                    minDist = dist1[i] + dist2[i];
                    ans = i;
                }
            }
        }
        return ans;
    }
};