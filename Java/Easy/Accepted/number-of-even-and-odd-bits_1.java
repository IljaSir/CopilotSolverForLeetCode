class Solution {
    public int[] evenOddBit(int n) {
        
        int even = 0;
        int odd = 0;
        int i = 0;
        while (n > 0) {
            if (i % 2 == 0) {
                if (n % 2 == 1) {
                    even++;
                }
            } else {
                if (n % 2 == 1) {
                    odd++;
                }
            }
            n = n / 2;
            i++;
        }
        return new int[]{even, odd};
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.evenOddBit(17);
        for (int i : result) {
            System.out.println(i);
        }
    }
}