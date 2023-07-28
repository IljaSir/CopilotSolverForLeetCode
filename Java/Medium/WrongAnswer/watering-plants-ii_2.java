class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        
        int i = 0;
        int j = plants.length - 1;
        int count = 0;
        int waterA = capacityA;
        int waterB = capacityB;
        while (i <= j) {
            if (waterA >= plants[i] && waterB >= plants[j]) {
                if (waterA >= waterB) {
                    waterA -= plants[i];
                    i++;
                } else {
                    waterB -= plants[j];
                    j--;
                }
            } else if (waterA >= plants[i]) {
                waterA -= plants[i];
                i++;
            } else if (waterB >= plants[j]) {
                waterB -= plants[j];
                j--;
            } else {
                waterA = capacityA;
                waterB = capacityB;
                count++;
            }
        }
        return count;
    }
}