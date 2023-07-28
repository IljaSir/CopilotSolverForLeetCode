class Solution {
public:
    bool canPlaceFlowers(vector<int>& flowerbed, int n) {
        
        int i = 0;
        int size = flowerbed.size();
        while (i < size) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == size - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                n--;
            }
            i++;
        }
        return n <= 0;
    }
};