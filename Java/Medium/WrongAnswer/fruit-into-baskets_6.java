class Solution {
    public int totalFruit(int[] fruits) {
        
        int result = 0;
        int last = -1;
        int lastCount = 0;
        int count = 0;
        for (int i = 0; i < fruits.length; i++) {
            if (fruits[i] == last) {
                lastCount++;
            } else {
                lastCount = 1;
                last = fruits[i];
            }
            if (count > 0 && fruits[i] != fruits[i - 1]) {
                count = lastCount;
            } else {
                count++;
            }
            result = Math.max(result, count + lastCount - 1);
        }
        return result;
    }
}