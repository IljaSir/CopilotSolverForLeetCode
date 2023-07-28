impl Solution {
    pub fn count_primes(n: i32) -> i32 {
        

        let mut is_prime = vec![true; n as usize];
        let mut count = 0;
        for i in 2..n {
            if is_prime[i as usize] {
                count += 1;
                let mut j = i * i;
                while j < n {
                    is_prime[j as usize] = false;
                    j += i;
                }
            }
        }
        count
    }
}