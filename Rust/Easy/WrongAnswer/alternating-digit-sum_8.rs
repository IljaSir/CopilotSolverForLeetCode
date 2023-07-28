impl Solution {
    pub fn alternate_digit_sum(n: i32) -> i32 {
        
        let mut s = n.to_string();
        let mut r = 0;
        let mut sign = 1;
        while let Some(c) = s.pop() {
            r += sign * c.to_digit(10).unwrap() as i32;
            sign = -sign;
        }
        r
    }
}