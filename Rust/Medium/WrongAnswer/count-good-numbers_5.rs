impl Solution {
    pub fn count_good_numbers(n: i64) -> i32 {
        
        let mut p = 1;
        let mut q = 1;
        let mut r = 1;
        let mut i = 0;
        let m = 1000000007;
        while i < n {
            p = p * 5 % m;
            q = q * 4 % m;
            r = r * 5 % m;
            i += 1;
        }
        (p + q) % m
    }
}