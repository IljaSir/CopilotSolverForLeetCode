impl Solution {
    pub fn make_equal(words: Vec<String>) -> bool {
        
        let mut cnt = vec![0; 26];
        for w in words {
            for c in w.bytes() {
                cnt[(c - b'a') as usize] += 1;
            }
        }
        for c in cnt {
            if c % words.len() != 0 {
                return false;
            }
        }
        true
    }
}