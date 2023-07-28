impl Solution {
    pub fn count_prime_set_bits(left: i32, right: i32) -> i32 {
        
        let mut count = 0;
        for i in left..=right {
            let mut num = i;
            let mut num_of_one = 0;
            while num > 0 {
                num_of_one += num & 1;
                num >>= 1;
            }
            if num_of_one == 2 || num_of_one == 3 || num_of_one == 5 || num_of_one == 7 || num_of_one == 11 || num_of_one == 13 || num_of_one == 17 || num_of_one == 19 {
                count += 1;
            }
        }
        count
    }
}