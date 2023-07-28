impl Solution {
    pub fn tribonacci(n: i32) -> i32 {
        
        match n {
            0 => 0,
            1 => 1,
            2 => 1,
            3..=i32::MAX => {
                let mut a = 0;
                let mut b = 1;
                let mut c = 1;
                for _ in 3..=n {
                    let t = a + b + c;
                    a = b;
                    b = c;
                    c = t;
                }
                c
            }
        }