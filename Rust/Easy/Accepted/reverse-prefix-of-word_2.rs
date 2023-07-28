impl Solution {
    pub fn reverse_prefix(word: String, ch: char) -> String {
        
        let mut chars = word.chars().collect::<Vec<char>>();
        let mut i = 0;
        while i < chars.len() && chars[i] != ch {
            i += 1;
        }
        if i < chars.len() {
            let mut j = 0;
            while j < i {
                chars.swap(j, i);
                j += 1;
                i -= 1;
            }
        }
        chars.into_iter().collect::<String>()
    }
}