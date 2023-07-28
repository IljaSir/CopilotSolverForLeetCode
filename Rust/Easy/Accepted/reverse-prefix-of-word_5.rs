impl Solution {
    pub fn reverse_prefix(word: String, ch: char) -> String {
        
        let mut v = word.chars().collect::<Vec<char>>();
        for i in 0..v.len() {
            if v[i] == ch {
                v[0..=i].reverse();
                return v.into_iter().collect();
            }
        }
        word
    }
}