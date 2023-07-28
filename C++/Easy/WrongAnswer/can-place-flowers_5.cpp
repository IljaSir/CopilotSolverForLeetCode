class Solution {
public:
    bool canPlaceFlowers(vector<int>& flowerbed, int n) {
        
        if (flowerbed.size() == 1) {
            if (flowerbed[0] == 0) {
                return 1 >= n;
            } else {
                return 0 >= n;
            }
        }
        int i = 0;
        int count = 0;
        while (i < flowerbed.size()) {
            if (flowerbed[i] == 1) {
                i += 2;
            } else {
                if (i == flowerbed.size() - 1) {
                    count++;
                    i += 2;
                } else {
                    if (flowerbed[i + 1] == 0) {
                        count++;
                        i += 3;
                    } else {
                        i += 2;
                    }
                }
            }
        }
        return count >= n;
    }
};