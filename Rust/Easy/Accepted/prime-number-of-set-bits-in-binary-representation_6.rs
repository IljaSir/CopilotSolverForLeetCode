impl Solution {
    pub fn count_prime_set_bits(left: i32, right: i32) -> i32 {
        
        let mut ans = 0;
        for i in left..=right {
            let mut count = 0;
            let mut j = i;
            while j > 0 {
                count += j & 1;
                j >>= 1;
            }
            if count == 2 || count == 3 || count == 5 || count == 7 || count == 11 || count == 13 || count == 17 || count == 19 {
                ans += 1;
            }
        }
        ans
    }
}