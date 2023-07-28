impl Solution {
    pub fn climb_stairs(n: i32) -> i32 {
        
        let mut a = 1;
        let mut b = 1;
        for i in 2..=n {
            let c = a + b;
            a = b;
            b = c;
        }
        b
    }
}