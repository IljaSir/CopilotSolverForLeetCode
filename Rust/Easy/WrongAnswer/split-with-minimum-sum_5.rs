impl Solution {
    pub fn split_num(num: i32) -> i32 {
        
        let mut num = num;
        let mut num1 = 0;
        let mut num2 = 0;
        let mut i = 1;
        while num > 0 {
            let digit = num % 10;
            num /= 10;
            if digit % 2 == 0 {
                num1 += digit * i;
            } else {
                num2 += digit * i;
            }
            i *= 10;
        }
        num1 + num2
    }
}