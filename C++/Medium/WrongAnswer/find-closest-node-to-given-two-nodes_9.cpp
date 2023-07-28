class Solution {
public:
    int closestMeetingNode(vector<int>& edges, int node1, int node2) {
        
        std::unordered_map<int, int> m;
        int n = edges.size();
        m[node1] = 0;
        m[node2] = 0;
        int node = node1;
        while (node >= 0) {
            if (m.find(node) != m.end()) {
                m[node] = 0;
            }
            node = edges[node];
        }
        node = node2;
        while (node >= 0) {
            if (m.find(node) != m.end()) {
                return node;
            }
            node = edges[node];
        }
        return -1;
    }
};