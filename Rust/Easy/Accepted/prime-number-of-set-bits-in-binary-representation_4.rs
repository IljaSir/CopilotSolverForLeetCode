impl Solution {
    pub fn count_prime_set_bits(left: i32, right: i32) -> i32 {
        
        let mut count = 0;
        for i in left..=right {
            let mut num = i;
            let mut bits = 0;
            while num > 0 {
                if num & 1 == 1 {
                    bits += 1;
                }
                num >>= 1;
            }
            if bits == 2 || bits == 3 || bits == 5 || bits == 7 || bits == 11 || bits == 13 || bits == 17 || bits == 19 {
                count += 1;
            }
        }
        count
    }
}