class Solution {
public:
    int closestMeetingNode(vector<int>& edges, int node1, int node2) {
        
        int n = edges.size();
        vector<int> visited(n, 0);
        int curr = node1;
        while (curr != -1) {
            visited[curr] = 1;
            curr = edges[curr];
        }
        curr = node2;
        while (curr != -1) {
            if (visited[curr] == 1) {
                return curr;
            }
            curr = edges[curr];
        }
        return -1;
    }
};