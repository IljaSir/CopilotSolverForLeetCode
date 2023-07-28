impl Solution {
    pub fn nth_super_ugly_number(n: i32, primes: Vec<i32>) -> i32 {
        

        let n = n as usize;
        let mut ugly = vec![0; n];
        ugly[0] = 1;

        let mut idx = vec![0; primes.len()];
        let mut factors = primes.clone();
        for i in 1..n {
            ugly[i] = factors.iter().min().unwrap();
            for (j, f) in factors.iter_mut().enumerate() {
                if *f == ugly[i] {
                    idx[j] += 1;
                    *f = primes[j] * ugly[idx[j]];
                }
            }
        }
        ugly[n-1]
    }
}