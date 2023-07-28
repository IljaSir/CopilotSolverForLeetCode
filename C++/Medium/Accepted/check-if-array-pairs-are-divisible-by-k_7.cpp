class Solution {
public:
    bool canArrange(vector<int>& arr, int k) {
        
        vector<int> count(k, 0);
        for (auto &a : arr) {
            ++count[((a % k) + k) % k];
        }
        for (int i = 1; i < k; ++i) {
            if (count[i] != count[k - i]) {
                return false;
            }
        }
        return count[0] % 2 == 0;
    }
};