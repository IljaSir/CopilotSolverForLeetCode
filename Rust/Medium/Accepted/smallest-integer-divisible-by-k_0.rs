impl Solution {
    pub fn smallest_repunit_div_by_k(k: i32) -> i32 {
        
        let mut r = 0;
        for n in 1..=k {
            r = (r * 10 + 1) % k;
            if r == 0 {
                return n;
            }
        }
        -1
    }
}