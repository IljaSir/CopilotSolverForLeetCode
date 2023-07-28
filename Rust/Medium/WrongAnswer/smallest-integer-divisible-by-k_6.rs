impl Solution {
    pub fn smallest_repunit_div_by_k(k: i32) -> i32 {
        
        let mut n = 1;
        let mut r = 1;
        while r != 0 {
            r = (r * 10 + 1) % k;
            n += 1;
        }
        n
    }
}