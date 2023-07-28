impl Solution {
    pub fn minimum_sum(num: i32) -> i32 {
        
        let mut num = num;
        let mut num1 = 0;
        let mut num2 = 0;
        let mut i = 0;
        while num > 0 {
            let digit = num % 10;
            if i % 2 == 0 {
                num1 = num1 * 10 + digit;
            } else {
                num2 = num2 * 10 + digit;
            }
            num /= 10;
            i += 1;
        }
        num1 + num2
    }
}