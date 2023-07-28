class Solution {
public:
    long long pickGifts(vector<int>& gifts, int k) {
        
        long long sum = 0;
        for (int i = 0; i < k; ++i) {
            int max = *max_element(gifts.begin(), gifts.end());
            int index = find(gifts.begin(), gifts.end(), max) - gifts.begin();
            sum += max;
            gifts[index] = floor(sqrt(max));
        }
        return sum;
    }
};