impl Solution {
    pub fn count_prime_set_bits(left: i32, right: i32) -> i32 {
        
        let mut count = 0;
        for i in left..=right {
            let mut set_bits = 0;
            let mut n = i;
            while n > 0 {
                set_bits += n & 1;
                n >>= 1;
            }
            count += match set_bits {
                2 | 3 | 5 | 7 | 11 | 13 | 17 | 19 => 1,
                _ => 0,
            };
        }
        count
    }
}