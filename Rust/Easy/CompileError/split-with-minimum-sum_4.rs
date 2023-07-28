impl Solution {
    pub fn split_num(num: i32) -> i32 {
        
        let mut num = num;
        let mut digits = vec![0; 10];
        while num > 0 {
            digits[num % 10] += 1;
            num /= 10;
        }
        let mut num1 = 0;
        let mut num2 = 0;
        let mut i = 0;
        while i < 10 {
            if digits[i] > 0 {
                if num1 <= num2 {
                    num1 = num1 * 10 + i;
                    digits[i] -= 1;
                } else {
                    num2 = num2 * 10 + i;
                    digits[i] -= 1;
                }
            } else {
                i += 1;
            }
        }
        num1 + num2
    }
}