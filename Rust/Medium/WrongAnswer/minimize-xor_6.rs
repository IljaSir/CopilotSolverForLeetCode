impl Solution {
    pub fn minimize_xor(num1: i32, num2: i32) -> i32 {
        
        let mut x = 0;
        let mut n1 = num1;
        let mut n2 = num2;
        for i in 0..32 {
            if n1 & 1 == n2 & 1 {
                x += (n1 & 1) << i;
            } else {
                x += 1 << i;
            }
            n1 >>= 1;
            n2 >>= 1;
        }
        x
    }
}