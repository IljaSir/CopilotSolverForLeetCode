class Solution {
    public int findMinFibonacciNumbers(int k) {
        
        List<Integer> fibs = new ArrayList<>();
        fibs.add(1);
        fibs.add(1);
        while (fibs.get(fibs.size() - 1) < k) {
            fibs.add(fibs.get(fibs.size() - 1) + fibs.get(fibs.size() - 2));
        }
        int res = 0;
        for (int i = fibs.size() - 1; i >= 0; i--) {
            if (k >= fibs.get(i)) {
                k -= fibs.get(i);
                res++;
            }
        }
        return res;
    }
}