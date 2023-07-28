impl Solution {
    pub fn make_string_sorted(s: String) -> i32 {
        
        let mut count = vec![0; 26];
        let mut fact = vec![1; s.len() + 1];
        let mut inv = vec![1; s.len() + 1];
        let mut res = 0;
        for i in 1..=s.len() {
            fact[i] = (fact[i - 1] * i as i64) % 1_000_000_007;
            inv[i] = Self::pow_mod(fact[i], 1_000_000_005, 1_000_000_007);
        }
        for ch in s.bytes() {
            count[(ch - b'a') as usize] += 1;
        }
        for i in 0..s.len() {
            let mut sum = 0;
            for j in 0..(s.bytes().nth(i).unwrap() - b'a') as usize {
                sum += count[j];
            }
            for j in 0..26 {
                count[j] = (count[j] * inv[s.len() - i]) % 1_000_000_007;
            }
            res = (res + (sum * fact[s.len() - i - 1]) % 1_000_000_007) % 1_000_000_007;
            count[(s.bytes().nth(i).unwrap() - b'a') as usize] -= 1;
        }
        res as i32
    }
    fn pow_mod(mut x: i64, mut n: i64, m: i64) -> i64 {
        let mut res = 1;
        while n > 0 {
            if n & 1 == 1 {
                res = (res * x) % m;
            }
            x = (x * x) % m;
            n >>= 1;
        }
        res
    }
}