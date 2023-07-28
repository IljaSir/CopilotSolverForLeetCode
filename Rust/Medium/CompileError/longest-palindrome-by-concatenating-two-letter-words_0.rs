impl Solution {
    pub fn longest_palindrome(words: Vec<String>) -> i32 {
        
        let mut ans = 0;
        let mut cnt = vec![0; 26];
        for word in words {
            let mut mask = 0;
            for c in word.chars() {
                mask ^= 1 << (c as u8 - b'a');
            }
            for i in 0..26 {
                if (mask & (1 << i)) == 0 {
                    ans = ans.max(cnt[i] + word.len() as i32);
                }
            }
            cnt[mask.trailing_zeros() as usize] = cnt[mask.trailing_zeros() as usize].max(word.len() as i32);
        }
        ans
    }
}