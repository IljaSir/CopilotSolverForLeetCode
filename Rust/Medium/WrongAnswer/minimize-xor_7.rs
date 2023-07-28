impl Solution {
    pub fn minimize_xor(num1: i32, num2: i32) -> i32 {
        
        let mut num = num1 ^ num2;
        if num == 0 {
            return 0;
        }
        let mut mask = 1;
        while num & mask == 0 {
            mask <<= 1;
        }
        let mut x = 0;
        while num > 0 {
            x |= mask;
            num &= !mask;
            mask <<= 1;
        }
        x
    }
}