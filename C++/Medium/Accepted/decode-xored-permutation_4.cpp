class Solution {
public:
    vector<int> decode(vector<int>& encoded) {
        
        int n = encoded.size();
        int total = 0;
        for (int i = 1; i <= n + 1; ++i) {
            total ^= i;
        }
        int odd = 0;
        for (int i = 1; i < n; i += 2) {
            odd ^= encoded[i];
        }
        vector<int> perm(n + 1);
        perm[0] = total ^ odd;
        for (int i = 0; i < n; ++i) {
            perm[i + 1] = perm[i] ^ encoded[i];
        }
        return perm;
    }
};