impl Solution {
    pub fn make_string_sorted(s: String) -> i32 {
        
        let mut s = s.as_bytes();
        let mut fact = vec![1; s.len() + 1];
        let mut count = vec![0; 26];
        let mut ans = 0;
        let mut modd = 1000000007;
        for i in 1..=s.len() {
            fact[i] = (fact[i - 1] * i) % modd;
        }
        for i in (0..s.len()).rev() {
            let idx = (s[i] - b'a') as usize;
            count[idx] += 1;
            let mut sum = 0;
            for j in 0..idx {
                sum += count[j];
            }
            ans = (ans + (sum * fact[s.len() - i - 1]) % modd) % modd;
            for j in idx + 1..26 {
                ans = (ans + (count[j] * fact[s.len() - i - 1]) % modd) % modd;
            }
        }
        ans
    }
}