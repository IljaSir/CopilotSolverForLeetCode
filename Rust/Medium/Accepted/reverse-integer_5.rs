impl Solution {
    pub fn reverse(x: i32) -> i32 {
        

        let mut result = 0;
        let mut num = x;
        while num != 0 {
            let digit = num % 10;
            num /= 10;
            if result > i32::MAX / 10 || (result == i32::MAX / 10 && digit > 7) {
                return 0;
            }
            if result < i32::MIN / 10 || (result == i32::MIN / 10 && digit < -8) {
                return 0;
            }
            result = result * 10 + digit;
        }
        result
    }
}