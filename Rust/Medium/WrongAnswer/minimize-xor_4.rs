impl Solution {
    pub fn minimize_xor(num1: i32, num2: i32) -> i32 {
        
        let mut x = num1 ^ num2;
        let mut mask = 1 << 30;
        while mask > 0 && (x & mask) == 0 {
            mask >>= 1;
        }
        if mask == 0 {
            return 0;
        }
        let mut y = 0;
        while mask > 0 {
            y |= mask;
            mask >>= 1;
        }
        y
    }
}