impl Solution {
    pub fn reverse_prefix(word: String, ch: char) -> String {
        
        let mut word = word.as_bytes().to_vec();
        let mut index = 0;
        for i in 0..word.len() {
            if word[i] == ch as u8 {
                index = i;
                break;
            }
        }
        for i in 0..index/2 + 1 {
            word.swap(i, index-i);
        }
        String::from_utf8(word).unwrap()
    }
}