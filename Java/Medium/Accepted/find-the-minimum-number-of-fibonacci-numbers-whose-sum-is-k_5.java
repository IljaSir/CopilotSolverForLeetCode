class Solution {
    public int findMinFibonacciNumbers(int k) {
        
        List<Integer> fib = new ArrayList<>();
        fib.add(1);
        fib.add(1);
        while (true) {
            int n = fib.size();
            int nextFib = fib.get(n - 1) + fib.get(n - 2);
            if (nextFib > k) {
                break;
            }
            fib.add(nextFib);
        }
        int count = 0;
        for (int i = fib.size() - 1; i >= 0; i--) {
            if (k >= fib.get(i)) {
                k -= fib.get(i);
                count++;
            }
        }
        return count;
    }
}