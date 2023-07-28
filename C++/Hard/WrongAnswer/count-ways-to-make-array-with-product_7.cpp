class Solution {
public:
    vector<int> waysToFillArray(vector<vector<int>>& queries) {
        
        int mod = 1e9 + 7;
        int maxn = 1e4 + 1;
        vector<int> primes;
        vector<int> is_prime(maxn, true);
        for (int i = 2; i < maxn; i++) {
            if (is_prime[i]) {
                primes.push_back(i);
                for (int j = i * i; j < maxn; j += i) {
                    is_prime[j] = false;
                }
            }
        }
        vector<int> ways(maxn, 1);
        for (int i = 0; i < primes.size(); i++) {
            int p = primes[i];
            for (int j = p; j < maxn; j += p) {
                int e = 0, t = j;
                while (t % p == 0) {
                    t /= p;
                    e++;
                }
                ways[j] = (long long)ways[j] * (e + 1) % mod;
            }
        }
        vector<int> ans;
        for (auto& query: queries) {
            ans.push_back(ways[query[1]]);
        }
        return ans;
    }
};