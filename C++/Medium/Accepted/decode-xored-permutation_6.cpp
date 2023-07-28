class Solution {
public:
    vector<int> decode(vector<int>& encoded) {
        
        int n = encoded.size() + 1;
        int allXor = 0;
        for (int i = 1; i <= n; i++) {
            allXor ^= i;
        }
        int oddXor = 0;
        for (int i = 1; i < n - 1; i += 2) {
            oddXor ^= encoded[i];
        }
        int first = allXor ^ oddXor;
        vector<int> perm(n);
        perm[0] = first;
        for (int i = 1; i < n; i++) {
            perm[i] = perm[i - 1] ^ encoded[i - 1];
        }
        return perm;
    }
};