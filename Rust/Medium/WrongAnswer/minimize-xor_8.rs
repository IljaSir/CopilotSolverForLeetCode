impl Solution {
    pub fn minimize_xor(num1: i32, num2: i32) -> i32 {
        
        let mut num = num1 ^ num2;
        let mut res = 0;
        let mut p = 1;
        while num > 0 {
            if num & 1 == 1 {
                res += p;
            }
            p <<= 1;
            num >>= 1;
        }
        res
    }
}