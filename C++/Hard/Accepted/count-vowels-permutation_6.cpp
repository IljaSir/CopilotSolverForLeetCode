class Solution {
public:
    int countVowelPermutation(int n) {
        
        long long int a = 1, e = 1, i = 1, o = 1, u = 1;
        long long int mod = 1000000007;
        for(int j=1; j<n; j++){
            long long int a1 = (e+i+u)%mod;
            long long int e1 = (a+i)%mod;
            long long int i1 = (e+o)%mod;
            long long int o1 = (i)%mod;
            long long int u1 = (i+o)%mod;
            a = a1;
            e = e1;
            i = i1;
            o = o1;
            u = u1;
        }
        return (a+e+i+o+u)%mod;
    }
};