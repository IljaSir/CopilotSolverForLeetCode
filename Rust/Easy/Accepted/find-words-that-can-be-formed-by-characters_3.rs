impl Solution {
    pub fn count_characters(words: Vec<String>, chars: String) -> i32 {
        
        let mut chars = chars.chars().collect::<Vec<char>>();
        chars.sort();
        let mut count = 0;
        for word in words {
            let mut word = word.chars().collect::<Vec<char>>();
            word.sort();
            let mut i = 0;
            let mut j = 0;
            while i < word.len() && j < chars.len() {
                if word[i] == chars[j] {
                    i += 1;
                }
                j += 1;
            }
            if i == word.len() {
                count += word.len() as i32;
            }
        }
        count
    }
}