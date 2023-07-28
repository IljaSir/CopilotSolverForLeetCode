class Solution {
public:
    int numSub(string s) {
        
        long long int count = 0;
        long long int mod = 1000000007;
        long long int sum = 0;
        for(int i = 0; i < s.size(); i++) {
            if(s[i] == '1') {
                count++;
            } else {
                sum = (sum + ((count * (count+1))/2)) % mod;
                count = 0;
            }
        }
        sum = (sum + ((count * (count+1))/2)) % mod;
        return sum;
    }
};