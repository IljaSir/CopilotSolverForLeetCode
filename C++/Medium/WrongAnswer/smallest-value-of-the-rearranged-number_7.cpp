class Solution {
public:
    long long smallestNumber(long long num) {
        
        if(num<0)
        {
            num = -num;
            return -smallestNumber(num);
        }
        vector<int> digits;
        while(num)
        {
            digits.push_back(num%10);
            num /= 10;
        }
        sort(digits.begin(), digits.end());
        long long ans = 0;
        for(int i = 0; i < digits.size(); i++)
        {
            ans*=10;
            ans+=digits[i];
        }
        return ans;
    }
};