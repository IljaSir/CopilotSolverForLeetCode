class Solution {
public:
    int countHighestScoreNodes(vector<int>& parents) {
        
        int n = parents.size();
        vector<int> children(n, 0);
        vector<int> size(n, 1);
        vector<int> score(n, 1);
        int root = 0;
        for (int i = 0; i < parents.size(); i++) {
            if (parents[i] == -1) {
                root = i;
            } else {
                children[parents[i]]++;
            }
        }
        vector<int> q;
        q.push_back(root);
        for (int i = 0; i < q.size(); i++) {
            int x = q[i];
            if (children[x] == 0) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (parents[j] == x) {
                    q.push_back(j);
                }
            }
        }
        for (int i = q.size() - 1; i >= 0; i--) {
            int x = q[i];
            if (x == root) {
                continue;
            }
            size[parents[x]] += size[x];
            score[parents[x]] *= score[x];
            score[parents[x]] %= 1000000007;
        }
        int max_size = 0;
        for (int i = 0; i < n; i++) {
            if (size[i] > max_size) {
                max_size = size[i];
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (size[i] == max_size) {
                ans++;
            }
        }
        return ans;
    }
};