impl Solution {
    pub fn count_primes(n: i32) -> i32 {
        

        let n = n as usize;
        let mut is_prime = vec![true; n];
        let mut count = 0;
        for i in 2..n {
            if is_prime[i] {
                count += 1;
                let mut j = i * i;
                while j < n {
                    is_prime[j] = false;
                    j += i;
                }
            }
        }
        count as i32
    }
}