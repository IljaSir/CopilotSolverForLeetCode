impl Solution {
    pub fn my_sqrt(x: i32) -> i32 {
        
        let mut i: i32 = 0;
        while i * i <= x {
            i += 1;
        }
        i - 1
    }
}