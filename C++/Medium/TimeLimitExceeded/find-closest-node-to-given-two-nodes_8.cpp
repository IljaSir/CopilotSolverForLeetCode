class Solution {
public:
    int closestMeetingNode(vector<int>& edges, int node1, int node2) {
        
        int n = edges.size();
        int a = node1;
        int b = node2;
        vector<int> aPath;
        vector<int> bPath;
        while (a != -1) {
            aPath.push_back(a);
            a = edges[a];
        }
        while (b != -1) {
            bPath.push_back(b);
            b = edges[b];
        }
        int i = aPath.size() - 1;
        int j = bPath.size() - 1;
        while (i >= 0 && j >= 0 && aPath[i] == bPath[j]) {
            i--;
            j--;
        }
        return aPath[i + 1];
    }
};