impl Solution {
    pub fn climb_stairs(n: i32) -> i32 {
        
        let mut a: i32 = 1;
        let mut b: i32 = 1;
        for _ in 1..n {
            let c = a + b;
            a = b;
            b = c;
        }
        b
    }
}