impl Solution {
    pub fn count_primes(n: i32) -> i32 {
        

        let n = n as usize;
        let mut prime = vec![true; n];
        prime[0] = false;
        prime[1] = false;
        for i in 2..n {
            if prime[i] {
                let mut j = i + i;
                while j < n {
                    prime[j] = false;
                    j += i;
                }
            }
        }
        prime.iter().fold(0, |acc, x| if *x {acc + 1} else {acc})
    }
}