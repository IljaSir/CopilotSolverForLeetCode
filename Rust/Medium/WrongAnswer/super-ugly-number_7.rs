impl Solution {
    pub fn nth_super_ugly_number(n: i32, primes: Vec<i32>) -> i32 {
        

        let mut ugly = vec![1];
        let mut idx = vec![0; primes.len()];
        let mut vals = vec![0; primes.len()];
        let mut i = 1;
        while i < n as usize {
            for j in 0..primes.len() {
                vals[j] = ugly[idx[j]] * primes[j];
            }
            let min = vals.iter().min().unwrap();
            ugly.push(*min);
            for j in 0..primes.len() {
                if vals[j] == *min {
                    idx[j] += 1;
                }
            }
            i += 1;
        }
        ugly[n as usize - 1]
    }
}