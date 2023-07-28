impl Solution {
    pub fn minimum_one_bit_operations(n: i32) -> i32 {
        
        let mut x = n;
        let mut y = 0;
        while x != 0 {
            y ^= x;
            x >>= 1;
        }
        y
    }
}