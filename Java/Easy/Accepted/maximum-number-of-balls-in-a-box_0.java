class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = 0;
            int num = i;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        int max = 0;
        for (int count : map.values()) {
            max = Math.max(max, count);
        }
        return max;
    }
}