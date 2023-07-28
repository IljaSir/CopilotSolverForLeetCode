class Solution {
public:
    int closestMeetingNode(vector<int>& edges, int node1, int node2) {
        
        int n = edges.size();
        vector<int> nodes(n, -1);
        int i = node1;
        while (i != -1) {
            nodes[i] = 0;
            i = edges[i];
        }
        i = node2;
        while (i != -1) {
            if (nodes[i] == 0)
                nodes[i] = 1;
            i = edges[i];
        }
        int min = INT_MAX, minNode = -1;
        for (int i = 0; i < n; i++) {
            if (nodes[i] == 1) {
                int dist = abs(node1 - i) + abs(node2 - i);
                if (dist < min) {
                    min = dist;
                    minNode = i;
                }
            }
        }
        return minNode;
    }
};