impl Solution {
    pub fn make_equal(words: Vec<String>) -> bool {
        
        let mut count = [0; 26];
        for word in words {
            for c in word.chars() {
                count[c as usize - 'a' as usize] += 1;
            }
        }
        for c in count.iter() {
            if c % words.len() != 0 {
                return false;
            }
        }
        true
    }
}