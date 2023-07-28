impl Solution {
    pub fn my_sqrt(x: i32) -> i32 {
        
        let mut r = x;
        while r * r > x {
            r = (r + x / r) / 2;
        }
        return r;
    }
}