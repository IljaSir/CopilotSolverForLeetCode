impl Solution {
    pub fn can_be_typed_words(text: String, broken_letters: String) -> i32 {
        
        let mut res = 0;
        let mut broken = vec![false; 26];
        for c in broken_letters.chars() {
            broken[(c as u8 - 'a' as u8) as usize] = true;
        }
        for word in text.split_whitespace() {
            let mut ok = true;
            for c in word.chars() {
                if broken[(c as u8 - 'a' as u8) as usize] {
                    ok = false;
                    break;
                }
            }
            if ok {
                res += 1;
            }
        }
        res
    }
}