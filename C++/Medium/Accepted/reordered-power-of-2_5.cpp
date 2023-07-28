class Solution {
public:
    bool reorderedPowerOf2(int n) {
        
        vector<int> vec;
        while (n) {
            vec.push_back(n % 10);
            n /= 10;
        }
        sort(vec.begin(), vec.end());
        do {
            if (vec[0] == 0) {
                continue;
            }
            long long num = 0;
            for (int i = 0; i < vec.size(); ++i) {
                num = num * 10 + vec[i];
            }
            if (num & (num - 1)) {
                continue;
            }
            return true;
        } while (next_permutation(vec.begin(), vec.end()));
        return false;
    }
};