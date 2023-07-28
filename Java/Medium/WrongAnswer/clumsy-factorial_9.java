class Solution {
    public int clumsy(int n) {
        
        int[] op = new int[]{1, 2, 2, -1};
        int i = 0;
        int result = n;
        n--;
        while (n > 0) {
            int next = n;
            n--;
            if (i == 0) {
                result *= next;
            } else if (i == 1) {
                result /= next;
            } else if (i == 2) {
                result += next;
            } else {
                result -= next;
            }
            i = (i + 1) % 4;
        }
        return result;
    }
}