impl Solution {
    pub fn count_primes(n: i32) -> i32 {
        

        let mut primes = vec![true; n as usize];
        let mut count = 0;
        for i in 2..n {
            if primes[i as usize] {
                count += 1;
                let mut j = 2;
                while i * j < n {
                    primes[(i * j) as usize] = false;
                    j += 1;
                }
            }
        }
        count
    }
}