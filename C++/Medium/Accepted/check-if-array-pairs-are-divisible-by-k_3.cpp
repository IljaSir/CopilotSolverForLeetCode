class Solution {
public:
    bool canArrange(vector<int>& arr, int k) {
        
        vector<int> remainders(k, 0);
        for (int i = 0; i < arr.size(); i++) {
            remainders[((arr[i] % k) + k) % k]++;
        }
        if (remainders[0] % 2 != 0) {
            return false;
        }
        for (int i = 1; i <= k / 2; i++) {
            if (remainders[i] != remainders[k - i]) {
                return false;
            }
        }
        return true;
    }
};