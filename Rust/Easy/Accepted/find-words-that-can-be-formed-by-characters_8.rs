impl Solution {
    pub fn count_characters(words: Vec<String>, chars: String) -> i32 {
        
        let mut chars = chars.chars().collect::<Vec<char>>();
        let mut res = 0;
        for word in words {
            let mut word = word.chars().collect::<Vec<char>>();
            word.sort();
            chars.sort();
            let mut i = 0;
            let mut j = 0;
            while i < word.len() && j < chars.len() {
                if word[i] == chars[j] {
                    i += 1;
                }
                j += 1;
            }
            if i == word.len() {
                res += word.len();
            }
        }
        res as i32
    }
}