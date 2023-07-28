class Solution {
public:
    int kthGrammar(int n, int k) {
        
        if (n == 1) return 0;
        int x = kthGrammar(n-1, (k+1)/2);
        if (x == 0) return k%2;
        return 1-k%2;
    }
};