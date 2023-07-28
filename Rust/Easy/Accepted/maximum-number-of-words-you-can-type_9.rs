impl Solution {
    pub fn can_be_typed_words(text: String, broken_letters: String) -> i32 {
        
        let mut count = 0;
        let broken: Vec<char> = broken_letters.chars().collect();
        let words: Vec<&str> = text.split(' ').collect();
        for word in words {
            let mut flag = true;
            for c in word.chars() {
                if broken.contains(&c) {
                    flag = false;
                    break;
                }
            }
            if flag {
                count += 1;
            }
        }
        count
    }
}