class Solution {
    public int splitNum(int num) {
        
        int[] digits = new int[10];
        while (num > 0) {
            digits[num % 10]++;
            num /= 10;
        }
        int sum = 0;
        for (int i = 1; i < 10; i++) {
            if (digits[i] == 0) {
                continue;
            }
            int j = 0;
            int carry = 0;
            while (j < 10) {
                if (j == i) {
                    j++;
                }
                int temp = digits[j] + carry;
                carry = temp / 2;
                temp %= 2;
                digits[j] = temp;
                j++;
            }
            sum += i;
        }
        return sum;
    }
    public int splitNum2(int num) {
        int[] digits = new int[10];
        while (num > 0) {
            digits[num % 10]++;
            num /= 10;
        }
        int sum = 0;
        for (int i = 1; i < 10; i++) {
            if (digits[i] == 0) {
                continue;
            }
            int j = 0;
            int carry = 0;
            while (j < 10) {
                if (j == i) {
                    j++;
                }
                int temp = digits[j] + carry;
                carry = temp / 2;
                temp %= 2;
                digits[j] = temp;
                j++;
            }
            sum += i;
        }
        return sum;
    }
    public int splitNum3(int num) {
        int[] digits = new int[10];
        while (num > 0) {
            digits[num % 10]++;
            num /= 10;
        }
        int sum = 0;
        for (int i = 1; i < 10; i++) {
            if (digits[i] == 0) {
                continue;
            }
            int j = 0;
            int carry = 0;
            while (j < 10) {
                if (j == i) {
                    j++;
                }
                int temp = digits[j] + carry;
                carry = temp / 2;
                temp %= 2;
                digits[j] = temp;
                j++;
            }
            sum += i;
        }
        return sum;
    }
}