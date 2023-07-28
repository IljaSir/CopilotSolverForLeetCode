class Solution {
public:
    vector<int> cycleLengthQueries(int n, vector<vector<int>>& queries) {
        
        int m = queries.size();
        vector<int> answer(m, 0);
        vector<int> parent(1 << n, 0);
        vector<int> depth(1 << n, 0);
        for (int i = 1; i < (1 << n); i++) {
            parent[i] = i / 2;
            depth[i] = depth[i / 2] + 1;
        }
        for (int i = 0; i < m; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            int d = 0;
            while (a != b) {
                if (depth[a] < depth[b]) {
                    swap(a, b);
                }
                d += depth[a] - depth[b];
                a = parent[a];
            }
            answer[i] = d;
        }
        return answer;
    }
};