impl Solution {
    pub fn make_string_sorted(s: String) -> i32 {
        
        let mut cnt = [0; 26];
        let mut fact = [1; 3001];
        for i in 1..3001 {
            fact[i] = (fact[i - 1] * i as i64) % 1000000007;
        }
        let mut ans = 0;
        for i in (0..s.len()).rev() {
            let c = s[i..i + 1].chars().nth(0).unwrap() as usize - 'a' as usize;
            let mut sum = 0;
            for j in 0..c {
                sum = (sum + cnt[j]) % 1000000007;
            }
            ans = (ans + sum * fact[s.len() - i - 1]) % 1000000007;
            cnt[c] += 1;
        }
        ans as i32
    }
}