impl Solution {
    pub fn count_prime_set_bits(left: i32, right: i32) -> i32 {
        
        let mut count = 0;
        for i in left..=right {
            let n = i.count_ones();
            if n == 2 || n == 3 || n == 5 || n == 7 || n == 11 || n == 13 || n == 17 || n == 19 {
                count += 1;
            }
        }
        count
    }
}