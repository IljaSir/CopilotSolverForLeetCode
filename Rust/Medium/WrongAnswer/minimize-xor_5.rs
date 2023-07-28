impl Solution {
    pub fn minimize_xor(num1: i32, num2: i32) -> i32 {
        
        let mut x = num1 ^ num2;
        let mut y = 1;
        while x > 0 {
            y <<= 1;
            x >>= 1;
        }
        y - 1
    }
}