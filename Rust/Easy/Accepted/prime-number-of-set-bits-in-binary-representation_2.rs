impl Solution {
    pub fn count_prime_set_bits(left: i32, right: i32) -> i32 {
        
        let mut ans = 0;
        for i in left..=right {
            let bits = i.count_ones();
            if bits == 2 || bits == 3 || bits == 5 || bits == 7 || bits == 11 || bits == 13 || bits == 17 || bits == 19 {
                ans += 1;
            }
        }
        ans
    }
}