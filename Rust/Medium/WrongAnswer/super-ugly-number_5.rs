impl Solution {
    pub fn nth_super_ugly_number(n: i32, primes: Vec<i32>) -> i32 {
        

        if n == 1 {
            return 1;
        }
        let mut ugly = vec![1];
        let mut pointers = vec![0; primes.len()];
        let mut next = vec![0; primes.len()];
        for _ in 1..n {
            for i in 0..primes.len() {
                next[i] = ugly[pointers[i]] * primes[i];
            }
            let mut min = next[0];
            for i in 1..next.len() {
                if next[i] < min {
                    min = next[i];
                }
            }
            ugly.push(min);
            for i in 0..primes.len() {
                if next[i] == min {
                    pointers[i] += 1;
                }
            }
        }
        ugly[n as usize - 1]
    }
}