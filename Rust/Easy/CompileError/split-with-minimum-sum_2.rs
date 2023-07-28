impl Solution {
    pub fn split_num(num: i32) -> i32 {
        
        let mut num = num;
        let mut digits = [0; 10];
        while num > 0 {
            digits[(num % 10) as usize] += 1;
            num /= 10;
        }
        let mut num1 = 0;
        let mut num2 = 0;
        let mut carry = 0;
        for i in (1..10).rev() {
            if digits[i] == 0 {
                continue;
            }
            if digits[i] % 2 == 0 {
                num1 = num1 * 10 + i;
                num2 = num2 * 10 + i;
            } else {
                if carry == 0 {
                    num1 = num1 * 10 + i;
                    num2 = num2 * 10;
                    carry = 1;
                } else {
                    num1 = num1 * 10;
                    num2 = num2 * 10 + i;
                    carry = 0;
                }
            }
            digits[i] -= 2;
        }
        num1 + num2
    }
}