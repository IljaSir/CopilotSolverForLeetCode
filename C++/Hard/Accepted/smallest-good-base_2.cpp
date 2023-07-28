class Solution {
public:
    string smallestGoodBase(string n) {
        
        int64_t num = stol(n);
        int64_t max_base = log(num+1)/log(2);
        for (int64_t base = max_base; base > 1; base--) {
            int64_t k = pow(num, 1.0/(base-1));
            int64_t sum = 1, cur = 1;
            for (int i = 1; i < base; i++) {
                cur *= k;
                sum += cur;
            }
            if (sum == num) {
                return to_string(k);
            }
        }
        return to_string(num-1);
    }
};