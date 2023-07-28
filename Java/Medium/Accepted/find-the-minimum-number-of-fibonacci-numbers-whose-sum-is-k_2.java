class Solution {
    public int findMinFibonacciNumbers(int k) {
        
        List<Integer> fibs = new ArrayList<>();
        fibs.add(1);
        fibs.add(1);
        while (true) {
            int n = fibs.get(fibs.size() - 1) + fibs.get(fibs.size() - 2);
            if (n > k) {
                break;
            }
            fibs.add(n);
        }
        int count = 0;
        for (int i = fibs.size() - 1; i >= 0; i--) {
            if (k >= fibs.get(i)) {
                k -= fibs.get(i);
                count++;
            }
        }
        return count;
    }
}