impl Solution {
    pub fn reverse_prefix(word: String, ch: char) -> String {
        
        let mut s = word.clone();
        let mut i = 0;
        for c in word.chars() {
            if c == ch {
                break;
            }
            i += 1;
        }
        if i < word.len() {
            let mut j = 0;
            while j < i {
                s.remove(j);
                s.insert(i, word.chars().nth(j).unwrap());
                j += 1;
                i -= 1;
            }
        }
        s
    }
}