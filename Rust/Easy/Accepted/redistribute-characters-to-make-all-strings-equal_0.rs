impl Solution {
    pub fn make_equal(words: Vec<String>) -> bool {
        
        let mut cnt = vec![0; 26];
        for word in &words {
            for c in word.chars() {
                cnt[c as usize - 'a' as usize] += 1;
            }
        }
        for i in 0..26 {
            if cnt[i] % words.len() != 0 {
                return false;
            }
        }
        true
    }
}