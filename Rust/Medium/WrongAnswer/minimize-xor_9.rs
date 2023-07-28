impl Solution {
    pub fn minimize_xor(num1: i32, num2: i32) -> i32 {
        
        let mut x = 0;
        let mut y = 0;
        let mut z = 0;
        let mut i = 30;
        while i >= 0 {
            let b1 = (num1 >> i) & 1;
            let b2 = (num2 >> i) & 1;
            if b1 == b2 {
                if b1 == 1 {
                    x = (x << 1) | 1;
                } else {
                    x = x << 1;
                }
            } else {
                if y == 0 {
                    y = 1;
                    z = x;
                }
                x = x << 1;
            }
            i -= 1;
        }
        if y == 0 {
            z = x;
        }
        z
    }
}