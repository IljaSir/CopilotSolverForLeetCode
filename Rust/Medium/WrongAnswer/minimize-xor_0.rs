impl Solution {
    pub fn minimize_xor(num1: i32, num2: i32) -> i32 {
        
        let mut n = num1 ^ num2;
        let mut r = 1;
        while n > 0 {
            n >>= 1;
            r <<= 1;
        }
        r - 1
    }
}