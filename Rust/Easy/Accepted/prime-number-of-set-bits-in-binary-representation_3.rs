impl Solution {
    pub fn count_prime_set_bits(left: i32, right: i32) -> i32 {
        
        let mut prime = vec![2, 3, 5, 7, 11, 13, 17, 19];
        let mut count = 0;
        for i in left..=right {
            let mut num = i;
            let mut bit = 0;
            while num > 0 {
                if num & 1 == 1 {
                    bit += 1;
                }
                num >>= 1;
            }
            if prime.contains(&bit) {
                count += 1;
            }
        }
        count
    }
}