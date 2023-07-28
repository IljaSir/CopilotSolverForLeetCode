class Solution {
public:
    int minimumBoxes(int n) {
        
        int layer = 1;
        int layerSum = 1;
        while (layerSum < n) {
            ++layer;
            layerSum += layer * (layer + 1) / 2;
        }
        if (layerSum == n) {
            return layerSum;
        }
        int remain = n - layerSum + layer * (layer + 1) / 2;
        int box = 0;
        while (remain > 0) {
            ++box;
            remain -= box;
        }
        return layer * (layer + 1) / 2 + box;
    }
};