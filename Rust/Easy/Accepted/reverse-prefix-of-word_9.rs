impl Solution {
    pub fn reverse_prefix(word: String, ch: char) -> String {
        
        let mut ret = word.clone();
        let mut i = 0;
        for c in word.chars() {
            if c == ch {
                ret.replace_range(0..i+1, &word[0..i+1].chars().rev().collect::<String>());
                break;
            }
            i += 1;
        }
        ret
    }
}