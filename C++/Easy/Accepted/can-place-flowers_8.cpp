class Solution {
public:
    bool canPlaceFlowers(vector<int>& flowerbed, int n) {
        
        int len = flowerbed.size();
        int i = 0;
        int count = 0;
        while (i < len) {
            if (flowerbed[i] == 0) {
                if ((i == 0 || flowerbed[i - 1] == 0) && (i == len - 1 || flowerbed[i + 1] == 0)) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
            i++;
        }
        return count >= n;
    }
};