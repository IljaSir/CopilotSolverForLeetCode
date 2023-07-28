impl Solution {
    pub fn make_equal(words: Vec<String>) -> bool {
        
        let mut c = [0; 26];
        for s in words {
            for c in s.bytes() {
                c[c as usize - 'a' as usize] += 1;
            }
        }
        for i in 0..26 {
            if c[i] % words.len() != 0 {
                return false;
            }
        }
        true
    }
}