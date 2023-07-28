class Solution {
public:
    int closestMeetingNode(vector<int>& edges, int node1, int node2) {
        
        int n = edges.size();
        set<int> visited;
        queue<int> q;
        q.push(node1);
        visited.insert(node1);
        while (!q.empty()) {
            int node = q.front(); q.pop();
            if (node == node2) {
                return node;
            }
            if (edges[node] != -1) {
                if (visited.find(edges[node]) == visited.end()) {
                    q.push(edges[node]);
                    visited.insert(edges[node]);
                }
            }
        }
        visited.clear();
        q.push(node2);
        visited.insert(node2);
        while (!q.empty()) {
            int node = q.front(); q.pop();
            if (node == node1) {
                return node;
            }
            if (edges[node] != -1) {
                if (visited.find(edges[node]) == visited.end()) {
                    q.push(edges[node]);
                    visited.insert(edges[node]);
                }
            }
        }
        return -1;
    }
    int findClosest(vector<int>& edges, int node1, int node2) {
        int n = edges.size();
        int node = closestMeetingNode(edges, node1, node2);
        if (node == -1) {
            return -1;
        }
        int node1_to_node = 0, node2_to_node = 0;
        while (node1 != node) {
            node1 = edges[node1];
            node1_to_node++;
        }
        while (node2 != node) {
            node2 = edges[node2];
            node2_to_node++;
        }
        return max(node1_to_node, node2_to_node);
    }
};