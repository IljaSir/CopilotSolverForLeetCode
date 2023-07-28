class Solution {
public:
    long long pickGifts(vector<int>& gifts, int k) {
        
        long long sum = 0;
        for (auto& i: gifts) sum += i;
        while (k--) {
            auto max = *max_element(gifts.begin(), gifts.end());
            sum -= max;
            sum += sqrt(max);
            for (auto& i: gifts) {
                if (i == max) {
                    i = sqrt(i);
                    break;
                }
            }
        }
        return sum;
    }
};