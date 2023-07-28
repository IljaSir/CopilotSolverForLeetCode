impl Solution {
    pub fn alternate_digit_sum(n: i32) -> i32 {
        
        let mut s = n.to_string();
        let mut sum = 0;
        let mut sign = 1;
        for c in s.chars() {
            sum += sign * c.to_digit(10).unwrap() as i32;
            sign *= -1;
        }
        sum
    }
}