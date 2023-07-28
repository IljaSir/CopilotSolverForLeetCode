impl Solution {
    pub fn can_construct(s: String, k: i32) -> bool {
        
        let mut cnt = vec![0; 26];
        for c in s.chars() {
            cnt[c as usize - 'a' as usize] += 1;
        }
        let mut odd = 0;
        for i in 0..26 {
            if cnt[i] % 2 == 1 {
                odd += 1;
            }
        }
        odd <= k && k <= s.len() as i32
    }
}