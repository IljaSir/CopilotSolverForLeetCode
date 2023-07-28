class Solution {
public:
    vector<int> getNoZeroIntegers(int n) {
        
        int a = 1;
        int b = n - 1;
        while(a <= b){
            if(a % 10 != 0 && b % 10 != 0){
                return {a, b};
            }
            a++;
            b--;
        }
        return {};
    }
};