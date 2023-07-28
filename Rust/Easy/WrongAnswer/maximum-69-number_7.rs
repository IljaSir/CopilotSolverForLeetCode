impl Solution {
    pub fn maximum69_number (num: i32) -> i32 {
        
        let mut num = num;
        let mut result = 0;
        let mut i = 0;
        while num > 0 {
            let digit = num % 10;
            if digit == 6 && result == 0 {
                result = 9 * 10_i32.pow(i);
            } else {
                result += digit * 10_i32.pow(i);
            }
            num /= 10;
            i += 1;
        }
        result
    }
}