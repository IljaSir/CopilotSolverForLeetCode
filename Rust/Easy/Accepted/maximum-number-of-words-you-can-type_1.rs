impl Solution {
    pub fn can_be_typed_words(text: String, broken_letters: String) -> i32 {
        
        let mut can_type = true;
        let mut count = 0;
        for c in text.chars() {
            if c == ' ' {
                if can_type {
                    count += 1;
                }
                can_type = true;
            } else if broken_letters.contains(c) {
                can_type = false;
            }
        }
        if can_type {
            count += 1;
        }
        count
    }
}