impl Solution {
    pub fn count_characters(words: Vec<String>, chars: String) -> i32 {
        
        let mut res = 0;
        for word in words {
            if Solution::is_good(&word, &chars) {
                res += word.len();
            }
        }
        res as i32
    }
    
    fn is_good(word: &str, chars: &str) -> bool {
        let mut chars = chars.chars().collect::<Vec<_>>();
        for c in word.chars() {
            if let Some(i) = chars.iter().position(|&x| x == c) {
                chars.remove(i);
            } else {
                return false;
            }
        }
        true
    }
}