class Solution {
public:
    bool validateBinaryTreeNodes(int n, vector<int>& leftChild, vector<int>& rightChild) {
        
        vector<int> in(n, 0);
        for (int i = 0; i < n; ++i) {
            if (leftChild[i] != -1) {
                in[leftChild[i]]++;
            }
            if (rightChild[i] != -1) {
                in[rightChild[i]]++;
            }
        }
        int root = -1;
        for (int i = 0; i < n; ++i) {
            if (in[i] == 0) {
                if (root == -1) {
                    root = i;
                } else {
                    return false;
                }
            } else if (in[i] > 1) {
                return false;
            }
        }
        if (root == -1) {
            return false;
        }
        int cnt = 0;
        queue<int> q;
        q.push(root);
        while (!q.empty()) {
            int i = q.front();
            q.pop();
            cnt++;
            if (leftChild[i] != -1) {
                q.push(leftChild[i]);
            }
            if (rightChild[i] != -1) {
                q.push(rightChild[i]);
            }
        }
        return cnt == n;
    }
};