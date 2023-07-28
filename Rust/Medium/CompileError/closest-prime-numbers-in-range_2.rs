impl Solution {
    pub fn closest_primes(left: i32, right: i32) -> Vec<i32> {
        
        let mut i = left;
        while i <= right {
            if is_prime(i) {
                if is_prime(i - 2) {
                    return vec![i - 2, i];
                }
                if is_prime(i + 2) {
                    return vec![i, i + 2];
                }
            }
            i += 1;
        }
        vec![-1, -1]
    }
}