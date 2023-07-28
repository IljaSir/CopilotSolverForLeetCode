impl Solution {
    pub fn smallest_repunit_div_by_k(k: i32) -> i32 {
        
        if k % 2 == 0 || k % 5 == 0 {
            return -1;
        }
        let mut n = 0;
        for len in 1..=k {
            n = (n * 10 + 1) % k;
            if n == 0 {
                return len;
            }
        }
        -1
    }
}