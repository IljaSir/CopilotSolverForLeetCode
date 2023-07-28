impl Solution {
    pub fn minimize_xor(num1: i32, num2: i32) -> i32 {
        
        if num1 == num2 {
            return 0;
        }
        let mut x = 0;
        for i in 0..32 {
            if (num1 & (1 << i)) != (num2 & (1 << i)) {
                x |= 1 << i;
            }
        }
        x
    }
}