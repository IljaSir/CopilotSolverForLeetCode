class Solution {
    public int findMinFibonacciNumbers(int k) {
        
        int a = 1, b = 1;
        List<Integer> list = new ArrayList<>();
        while (a <= k) {
            list.add(a);
            int temp = a;
            a = b;
            b = temp + b;
        }
        int count = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) <= k) {
                k -= list.get(i);
                count++;
            }
            if (k == 0) {
                break;
            }
        }
        return count;
    }
}