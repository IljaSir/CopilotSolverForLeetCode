class Solution {
public:
    long long smallestNumber(long long num) {
        
        vector<int> digits;
        while(num){
            digits.push_back(num%10);
            num/=10;
        }
        sort(digits.begin(), digits.end());
        long long res=0;
        for(int i=0; i<digits.size(); i++){
            res*=10;
            res+=digits[i];
        }
        return res;
    }
    int minPartitions(string n) {
        long long num=0;
        for(int i=0; i<n.size(); i++){
            num*=10;
            num+=n[i]-'0';
        }
        long long res=smallestNumber(num);
        int ans=0;
        while(res){
            ans=max(ans, (int)(res%10));
            res/=10;
        }
        return ans;
    }
};