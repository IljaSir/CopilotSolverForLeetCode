class Solution {
public:
    int totalStrength(vector<int>& strength) {
        
        long long int mod = 1000000007;
        long long int sum = 0;
        long long int max = 0;
        int n = strength.size();
        for(int i = 0; i < n; i++){
            if(strength[i] > max){
                max = strength[i];
            }
            sum = sum + strength[i];
        }
        return (max * sum) % mod;
    }
};