class Solution {
    public int findMinFibonacciNumbers(int k) {
        
        int count = 0;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        int i = 2;
        while (list.get(i - 1) < k) {
            list.add(list.get(i - 1) + list.get(i - 2));
            i++;
        }
        for (int j = list.size() - 1; j >= 0; j--) {
            if (list.get(j) <= k) {
                count++;
                k -= list.get(j);
            }
        }
        return count;
    }
}