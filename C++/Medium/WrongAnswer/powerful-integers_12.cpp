class Solution {
public:
    vector<int> powerfulIntegers(int x, int y, int bound) {
        
        vector<int> result;
        int i = 0;
        int j = 0;
        int power = 1;
        while (power < bound) {
            while (power < bound) {
                int sum = power + pow(y, j);
                if (sum <= bound) {
                    result.push_back(sum);
                }
                j++;
                power = pow(x, i) + pow(y, j);
            }
            i++;
            j = 0;
            power = pow(x, i) + pow(y, j);
        }
        sort(result.begin(), result.end());
        result.erase(unique(result.begin(), result.end()), result.end());
        return result;
    }
};