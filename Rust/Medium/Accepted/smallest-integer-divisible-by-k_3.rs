impl Solution {
    pub fn smallest_repunit_div_by_k(k: i32) -> i32 {
        
        if k % 2 == 0 || k % 5 == 0 {
            return -1;
        }
        let mut n = 1;
        let mut i = 1;
        while n % k != 0 {
            n = (n * 10 + 1) % k;
            i += 1;
        }
        i
    }
}