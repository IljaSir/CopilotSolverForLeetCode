class Solution {
public:
    long long smallestNumber(long long num) {
        
        if(num==0) return 0;
        vector<int> v;
        bool neg = false;
        if(num<0) neg = true;
        num = abs(num);
        while(num>0){
            v.push_back(num%10);
            num/=10;
        }
        sort(v.begin(),v.end());
        long long ans = 0;
        for(auto x:v){
            ans = ans*10 + x;
        }
        if(neg) return -ans;
        return ans;
    }
};