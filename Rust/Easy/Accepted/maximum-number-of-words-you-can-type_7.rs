impl Solution {
    pub fn can_be_typed_words(text: String, broken_letters: String) -> i32 {
        
        let mut count = 0;
        for word in text.split_ascii_whitespace() {
            let mut is_broken = false;
            for ch in word.chars() {
                if broken_letters.contains(ch) {
                    is_broken = true;
                    break;
                }
            }
            if !is_broken {
                count += 1;
            }
        }
        count
    }
}