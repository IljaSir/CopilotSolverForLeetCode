impl Solution {
    pub fn count_digits(num: i32) -> i32 {
        
        let mut num = num;
        let mut counter = 0;
        while num > 0 {
            let digit = num % 10;
            if digit > 0 && num % digit == 0 {
                counter += 1;
            }
            num /= 10;
        }
        counter
    }
}