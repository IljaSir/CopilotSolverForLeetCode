impl Solution {
    pub fn nth_super_ugly_number(n: i32, primes: Vec<i32>) -> i32 {
        

        let mut ugly = vec![1];
        let mut idx = vec![0; primes.len()];
        let mut next = vec![1; primes.len()];
        let mut i = 1;
        while i < n {
            let mut min = next[0];
            for j in 1..primes.len() {
                if next[j] < min {
                    min = next[j];
                }
            }
            ugly.push(min);
            for j in 0..primes.len() {
                if next[j] == min {
                    idx[j] += 1;
                    next[j] = ugly[idx[j]] * primes[j];
                }
            }
            i += 1;
        }
        ugly[n as usize - 1]
    }
}