class Solution {
public:
    int findMinFibonacciNumbers(int k) {
        
        vector<int> Fibo;
        Fibo.push_back(1);
        Fibo.push_back(1);
        int i = 2;
        while (true) {
            Fibo.push_back(Fibo[i-1] + Fibo[i-2]);
            if (Fibo[i] > k) {
                break;
            }
            i++;
        }
        int count = 0;
        for (int j = i; j >= 0; j--) {
            if (k >= Fibo[j]) {
                k -= Fibo[j];
                count++;
            }
            if (k == 0) {
                break;
            }
        }
        return count;
    }
};