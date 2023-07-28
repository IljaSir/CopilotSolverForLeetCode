impl Solution {
    pub fn minimize_xor(num1: i32, num2: i32) -> i32 {
        
        let mut num1 = num1;
        let mut num2 = num2;
        let mut res = 0;
        let mut i = 0;
        while num1 != 0 || num2 != 0 {
            let bit1 = num1 & 1;
            let bit2 = num2 & 1;
            if bit1 == bit2 {
                res += bit1 << i;
            }
            num1 >>= 1;
            num2 >>= 1;
            i += 1;
        }
        res
    }
}