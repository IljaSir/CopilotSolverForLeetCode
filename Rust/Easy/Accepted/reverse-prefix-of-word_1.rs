impl Solution {
    pub fn reverse_prefix(word: String, ch: char) -> String {
        
        let mut word: Vec<char> = word.chars().collect();
        let mut i = 0;
        while i < word.len() {
            if word[i] == ch {
                break;
            }
            i += 1;
        }
        if i < word.len() {
            word[0..=i].reverse();
        }
        word.iter().collect()
    }
}