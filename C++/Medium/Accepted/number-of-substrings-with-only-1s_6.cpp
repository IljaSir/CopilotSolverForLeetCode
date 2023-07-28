class Solution {
public:
    int numSub(string s) {
        
        int n = s.size();
        long long int count = 0;
        long long int sum = 0;
        for(int i = 0; i < n; i++){
            if(s[i] == '1'){
                count++;
            }else{
                sum = (sum + (count * (count + 1)) / 2) % 1000000007;
                count = 0;
            }
        }
        sum = (sum + (count * (count + 1)) / 2) % 1000000007;
        return (int)sum;
    }
};