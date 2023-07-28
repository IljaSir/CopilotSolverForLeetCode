impl Solution {
    pub fn count_prime_set_bits(left: i32, right: i32) -> i32 {
        
        let mut count = 0;
        let mut i = left;
        while i <= right {
            let mut n = i;
            let mut count_1 = 0;
            while n > 0 {
                count_1 += n & 1;
                n = n >> 1;
            }
            if count_1 == 2 || count_1 == 3 || count_1 == 5 || count_1 == 7 || count_1 == 11 || count_1 == 13 || count_1 == 17 || count_1 == 19 {
                count += 1;
            }
            i += 1;
        }
        count
    }
}