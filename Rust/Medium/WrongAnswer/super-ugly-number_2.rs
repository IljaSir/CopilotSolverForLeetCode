impl Solution {
    pub fn nth_super_ugly_number(n: i32, primes: Vec<i32>) -> i32 {
        

        let n = n as usize;
        let mut ugly = vec![1; n];
        let mut idx = vec![0; primes.len()];
        for i in 1..n {
            ugly[i] = primes.iter().zip(idx.iter()).map(|(p, &j)| ugly[j] * p).min().unwrap();
            for (j, p) in primes.iter().enumerate() {
                if ugly[i] == ugly[idx[j]] * p {
                    idx[j] += 1;
                }
            }
        }
        ugly[n - 1]
    }
}