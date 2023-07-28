class Solution {
public:
    bool validateBinaryTreeNodes(int n, vector<int>& leftChild, vector<int>& rightChild) {
        
        vector<int> degree(n, 0);
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                degree[i]++;
                if (degree[leftChild[i]] == 2) {
                    return false;
                }
                degree[leftChild[i]]++;
            }
            if (rightChild[i] != -1) {
                degree[i]++;
                if (degree[rightChild[i]] == 2) {
                    return false;
                }
                degree[rightChild[i]]++;
            }
        }
        int rootCount = 0;
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {
                rootCount++;
            }
        }
        return rootCount == 1;
    }
};