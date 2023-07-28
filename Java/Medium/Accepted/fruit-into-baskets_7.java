class Solution {
    public int totalFruit(int[] fruits) {
        
        int max = 0;
        int i = 0;
        int j = 0;
        int count = 0;
        int[] basket = new int[fruits.length];
        while (j < fruits.length) {
            if (basket[fruits[j]] == 0) {
                count++;
            }
            basket[fruits[j]]++;
            while (count > 2) {
                basket[fruits[i]]--;
                if (basket[fruits[i]] == 0) {
                    count--;
                }
                i++;
            }
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }
}