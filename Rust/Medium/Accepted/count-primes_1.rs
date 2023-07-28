impl Solution {
    pub fn count_primes(n: i32) -> i32 {
        

        let n = n as usize;
        let mut is_prime = vec![true; n];
        let mut count = 0;
        for i in 2..n {
            if is_prime[i] {
                count += 1;
                let mut j = 2;
                while i * j < n {
                    is_prime[i * j] = false;
                    j += 1;
                }
            }
        }
        count as i32
    }
}