class Solution {
public:
    int minimumSum(int num) {
        
        int a = num/1000;
        int b = (num/100)%10;
        int c = (num/10)%10;
        int d = num%10;
        return min(a+b+c+d, min(10*a+b+c+d, min(a+10*b+c+d, min(a+b+10*c+d, min(a+b+c+10*d, min(100*a+b+c+d, min(a+100*b+c+d, min(a+b+100*c+d, min(a+b+c+100*d, min(1000*a+b+c+d, min(a+1000*b+c+d, min(a+b+1000*c+d, min(a+b+c+1000*d, 10000)))))))))));
    }
};