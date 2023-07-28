class Solution {
public:
    bool validateBinaryTreeNodes(int n, vector<int>& leftChild, vector<int>& rightChild) {
        
        vector<int> in(n);
        for (int i = 0; i < n; ++i) {
            if (leftChild[i] != -1) {
                ++in[leftChild[i]];
            }
            if (rightChild[i] != -1) {
                ++in[rightChild[i]];
            }
        }
        int root = -1;
        for (int i = 0; i < n; ++i) {
            if (in[i] == 0) {
                if (root != -1) {
                    return false;
                }
                root = i;
            } else if (in[i] > 1) {
                return false;
            }
        }
        if (root == -1) {
            return false;
        }
        vector<bool> vis(n);
        queue<int> q;
        q.push(root);
        vis[root] = true;
        while (!q.empty()) {
            int u = q.front();
            q.pop();
            if (leftChild[u] != -1) {
                if (vis[leftChild[u]]) {
                    return false;
                }
                q.push(leftChild[u]);
                vis[leftChild[u]] = true;
            }
            if (rightChild[u] != -1) {
                if (vis[rightChild[u]]) {
                    return false;
                }
                q.push(rightChild[u]);
                vis[rightChild[u]] = true;
            }
        }
        return accumulate(vis.begin(), vis.end(), 0) == n;
    }
};