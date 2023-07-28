impl Solution {
    pub fn count_digits(num: i32) -> i32 {
        
        let mut count: i32 = 0;
        let mut num = num;
        while num > 0 {
            let digit = num % 10;
            if digit != 0 && num % digit == 0 {
                count += 1;
            }
            num /= 10;
        }
        count
    }
}