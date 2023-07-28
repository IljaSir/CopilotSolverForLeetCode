impl Solution {
    pub fn count_primes(n: i32) -> i32 {
        

        let n = n as usize;
        let mut is_prime = vec![true; n];
        for i in 2..n {
            if is_prime[i] {
                let mut j = i * i;
                while j < n {
                    is_prime[j] = false;
                    j += i;
                }
            }
        }
        let mut cnt = 0;
        for i in 2..n {
            if is_prime[i] {
                cnt += 1;
            }
        }
        cnt as i32
    }
}