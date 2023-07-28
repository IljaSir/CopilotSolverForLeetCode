impl Solution {
    pub fn longest_palindrome(s: String) -> i32 {
        
        let mut cnt = [0; 128];
        for c in s.chars() {
            cnt[c as usize] += 1;
        }
        let mut odd = 0;
        for c in cnt.iter() {
            if c % 2 == 1 {
                odd += 1;
            }
        }
        s.len() as i32 - odd + (odd > 0) as i32
    }
}