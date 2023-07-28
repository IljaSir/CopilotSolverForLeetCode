class Solution {
    public int totalFruit(int[] fruits) {
        
        int count = 0;
        int maxCount = 0;
        int maxFruit = 0;
        int previousFruit = -1;
        int secondFruit = -1;
        for (int i = 0; i < fruits.length; i++) {
            if (fruits[i] == previousFruit || fruits[i] == secondFruit) {
                count++;
            } else if (secondFruit == -1) {
                secondFruit = fruits[i];
                count++;
            } else {
                count = 1;
                previousFruit = secondFruit;
                secondFruit = fruits[i];
            }
            if (fruits[i] == secondFruit) {
                maxFruit = secondFruit;
            } else {
                maxFruit = previousFruit;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}