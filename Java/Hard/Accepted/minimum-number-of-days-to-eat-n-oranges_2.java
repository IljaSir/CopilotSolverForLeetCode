class Solution {
    public int minDays(int n) {
        
        Map<Integer, Integer> cache = new HashMap<>();
        return minDays(n, cache);
    }
    
    private int minDays(int n, Map<Integer, Integer> cache) {
        if (n <= 1) {
            return n;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int result = 1 + Math.min(n % 2 + minDays(n / 2, cache), n % 3 + minDays(n / 3, cache));
        cache.put(n, result);
        return result;
    }
}