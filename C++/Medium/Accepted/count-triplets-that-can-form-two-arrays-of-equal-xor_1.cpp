class Solution {
public:
    int countTriplets(vector<int>& arr) {
        
        int n = arr.size();
        vector<int> xors(n + 1);
        for (int i = 0; i < n; ++i) {
            xors[i + 1] = xors[i] ^ arr[i];
        }
        int count = 0;
        for (int i = 0; i < n; ++i) {
            for (int k = i + 1; k < n; ++k) {
                if (xors[i] == xors[k + 1]) {
                    count += k - i;
                }
            }
        }
        return count;
    }
};