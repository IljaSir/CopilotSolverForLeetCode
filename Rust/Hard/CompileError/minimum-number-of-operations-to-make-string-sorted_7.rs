impl Solution {
    pub fn make_string_sorted(s: String) -> i32 {
        
        let mut count = [0; 26];
        let mut fact = [1; 3001];
        let mut inv = [1; 3001];
        let mut ans = 0;
        let modu = 1_000_000_007;
        for i in 1..3001 {
            fact[i] = (fact[i - 1] * i as i64) % modu as i64;
            inv[i] = Self::pow(fact[i], modu as i64 - 2, modu as i64) as i32;
        }
        for &c in s.as_bytes() {
            let c = c - b'a';
            let mut sum = 0;
            for i in 0..c {
                sum += count[i];
            }
            ans = (ans + sum * fact[s.len() - 1]) % modu as i64;
            for i in c..26 {
                count[i] += 1;
            }
        }
        for i in 1..s.len() {
            let mut sum = 0;
            for j in 0..26 {
                sum = (sum + count[j]) % modu as i64;
                ans = (ans - fact[s.len() - i] * sum * inv[count[j]]) % modu as i64;
            }
            count[s.as_bytes()[i - 1] - b'a'] -= 1;
        }
        (ans + modu as i64) as i32
    }
    fn pow(mut a: i64, mut b: i64, modu: i64) -> i64 {
        let mut ans = 1;
        while b > 0 {
            if b & 1 == 1 {
                ans = (ans * a) % modu;
            }
            a = (a * a) % modu;
            b >>= 1;
        }
        ans
    }
}