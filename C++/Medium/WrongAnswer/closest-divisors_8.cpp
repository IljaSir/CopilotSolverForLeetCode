class Solution {
public:
    vector<int> closestDivisors(int num) {
        
        int d1 = divisors(num+1);
        int d2 = divisors(num+2);
        if(abs(d1 - d2) > abs(d1 - (num+1)/d1))
            return {d1, (num+1)/d1};
        else
            return {d2, (num+2)/d2};
    }
    int divisors(int num){
        int d = sqrt(num);
        while(num%d != 0)
            d--;
        return d;
    }
};