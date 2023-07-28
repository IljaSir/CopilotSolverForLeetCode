class Solution {
public:
    int createSortedArray(vector<int>& instructions) {
        
        int n = instructions.size();
        int mod = 1000000007;
        vector<int> bit(100001, 0);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int x = instructions[i];
            int left = get(bit, x - 1);
            int right = i - get(bit, x);
            ans = (ans + min(left, right)) % mod;
            update(bit, x, 1);
        }
        return ans;
    }
    
    void update(vector<int>& bit, int x, int delta) {
        int n = bit.size();
        for (int i = x; i < n; i += lowbit(i)) {
            bit[i] += delta;
        }
    }
    
    int get(vector<int>& bit, int x) {
        int res = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            res += bit[i];
        }
        return res;
    }
};