class Solution {
public:
    bool validateBinaryTreeNodes(int n, vector<int>& leftChild, vector<int>& rightChild) {
        
        if (n == 1) return true;
        vector<int> in(n, 0);
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                in[leftChild[i]]++;
                if (in[leftChild[i]] > 1) {
                    return false;
                }
            }
            if (rightChild[i] != -1) {
                in[rightChild[i]]++;
                if (in[rightChild[i]] > 1) {
                    return false;
                }
            }
        }
        int root = 0;
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                root = i;
                break;
            }
        }
        queue<int> q;
        q.push(root);
        int count = 0;
        while (!q.empty()) {
            int node = q.front();
            q.pop();
            count++;
            if (leftChild[node] != -1) {
                q.push(leftChild[node]);
            }
            if (rightChild[node] != -1) {
                q.push(rightChild[node]);
            }
        }
        return count == n;
    }
};