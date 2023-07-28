impl Solution {
    pub fn reverse_prefix(word: String, ch: char) -> String {
        
        let mut tmp = word.chars().collect::<Vec<char>>();
        let mut i = 0;
        while i < tmp.len() {
            if tmp[i] == ch {
                break;
            }
            i += 1;
        }
        if i < tmp.len() {
            tmp[0..=i].reverse();
        }
        tmp.iter().collect()
    }
}