impl Solution {
    pub fn can_construct(s: String, k: i32) -> bool {
        
        if s.len() < k as usize { return false; }
        if s.len() == k as usize { return true; }
        let mut freq = vec![0; 26];
        for c in s.chars() {
            freq[c as usize - 'a' as usize] += 1;
        }
        let mut odd_freq = 0;
        for i in 0..freq.len() {
            if freq[i] % 2 == 1 {
                odd_freq += 1;
            }
        }
        odd_freq <= k
    }
}