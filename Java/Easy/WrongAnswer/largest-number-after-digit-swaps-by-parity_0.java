class Solution {
    public int largestInteger(int num) {
        
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        while (num > 0) {
            int digit = num % 10;
            if (digit % 2 == 0) {
                even.add(digit);
            } else {
                odd.add(digit);
            }
            num /= 10;
        }
        Collections.sort(odd, Collections.reverseOrder());
        Collections.sort(even, Collections.reverseOrder());
        int res = 0;
        while (!odd.isEmpty() || !even.isEmpty()) {
            if (!odd.isEmpty()) {
                res = res * 10 + odd.remove(0);
            }
            if (!even.isEmpty()) {
                res = res * 10 + even.remove(0);
            }
        }
        return res;
    }
}