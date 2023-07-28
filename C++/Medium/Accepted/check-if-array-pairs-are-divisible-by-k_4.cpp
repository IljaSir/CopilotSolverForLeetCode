class Solution {
public:
    bool canArrange(vector<int>& arr, int k) {
        
        unordered_map<int, int> m;
        for (int i : arr) {
            m[(i % k + k) % k]++;
        }
        for (int i = 1; i < k; i++) {
            if (m[i] != m[k - i]) {
                return false;
            }
        }
        return m[0] % 2 == 0;
    }
};