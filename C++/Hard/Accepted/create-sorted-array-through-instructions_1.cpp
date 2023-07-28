class Solution {
public:
    int createSortedArray(vector<int>& instructions) {
        
        int n = instructions.size();
        int mod = 1e9 + 7;
        vector<int> tree(100001, 0);
        int res = 0;
        for (int i = 0; i < n; i++) {
            int left = sum(tree, instructions[i] - 1);
            int right = sum(tree, 100000) - sum(tree, instructions[i]);
            res = (res + min(left, right)) % mod;
            update(tree, instructions[i]);
        }
        return res;
    }
    int sum(vector<int>& tree, int i) {
        int res = 0;
        while (i > 0) {
            res += tree[i];
            i -= i & (-i);
        }
        return res;
    }
    void update(vector<int>& tree, int i) {
        while (i < 100001) {
            tree[i] += 1;
            i += i & (-i);
        }
    }
};