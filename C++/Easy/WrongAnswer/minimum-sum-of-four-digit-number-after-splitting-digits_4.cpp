class Solution {
public:
    int minimumSum(int num) {
        
        int n1 = num / 100;
        int n2 = num % 100;
        int n3 = num / 10;
        int n4 = num % 10;
        int n5 = num / 1000;
        int n6 = num % 1000;
        int n7 = num / 1000;
        int n8 = num % 100;
        int n9 = num / 100;
        int n10 = num % 10;
        return min(min(n1+n2, n3+n4), min(n5+n6, n7+n8)) + min(n9, n10);
    }
};