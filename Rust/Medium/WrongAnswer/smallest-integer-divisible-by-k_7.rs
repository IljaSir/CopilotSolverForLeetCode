impl Solution {
    pub fn smallest_repunit_div_by_k(k: i32) -> i32 {
        
        let mut len = 1;
        let mut n = 1;
        while n % k != 0 {
            n = (n * 10 + 1) % k;
            len += 1;
        }
        if n == 0 {
            return len;
        }
        -1
    }
}