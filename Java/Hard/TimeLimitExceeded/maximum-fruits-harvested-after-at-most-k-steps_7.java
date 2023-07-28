class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        
        int n = fruits.length;
        int left = startPos, right = startPos;
        int res = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (left >= 0 || right < n) {
            if (map.size() <= 2) {
                res = Math.max(res, sum);
            }
            if (map.size() <= 2) {
                if (right < n) {
                    int[] fruit = fruits[right];
                    map.put(fruit[0], map.getOrDefault(fruit[0], 0) + fruit[1]);
                    sum += fruit[1];
                    right++;
                }
            }
            if (map.size() > 2) {
                int[] fruit = fruits[left];
                map.put(fruit[0], map.get(fruit[0]) - 1);
                if (map.get(fruit[0]) == 0) {
                    map.remove(fruit[0]);
                }
                sum -= fruit[1];
                left--;
            }
        }
        return res;
    }
}