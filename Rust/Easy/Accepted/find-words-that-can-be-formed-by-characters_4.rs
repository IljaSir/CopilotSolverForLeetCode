impl Solution {
    pub fn count_characters(words: Vec<String>, chars: String) -> i32 {
        
        let mut ans = 0;
        let mut char_map = std::collections::HashMap::new();
        for c in chars.chars() {
            *char_map.entry(c).or_insert(0) += 1;
        }
        for word in words {
            let mut word_map = std::collections::HashMap::new();
            for c in word.chars() {
                *word_map.entry(c).or_insert(0) += 1;
            }
            let mut valid = true;
            for (k, v) in word_map.iter() {
                if let Some(count) = char_map.get(k) {
                    if count < v {
                        valid = false;
                        break;
                    }
                } else {
                    valid = false;
                    break;
                }
            }
            if valid {
                ans += word.len() as i32;
            }
        }
        ans
    }
}