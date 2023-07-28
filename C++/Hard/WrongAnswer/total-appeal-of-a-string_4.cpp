class Solution {
public:
    long long appealSum(string s) {
        
        long long sum = 0;
        long long n = s.size();
        long long count[26] = {0};
        for (long long i = 0; i < n; i++) {
            count[s[i] - 'a']++;
            sum += count[s[i] - 'a'] * (i + 1);
        }
        return sum;
    }
};