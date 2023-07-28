impl Solution {
    pub fn make_string_sorted(s: String) -> i32 {
        
        let mut a = vec![0; 26];
        let mut ans = 0;
        let mut fact = vec![1; s.len() + 1];
        for i in 1..fact.len() {
            fact[i] = (fact[i - 1] * i) % 1000000007;
        }
        for c in s.chars() {
            let c = c as usize - 'a' as usize;
            for i in 0..c {
                ans = (ans + a[i] * fact[s.len() - a.iter().sum::<i32>() as usize - 1]) % 1000000007;
            }
            a[c] += 1;
        }
        ans
    }
}