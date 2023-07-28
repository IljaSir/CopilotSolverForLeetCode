impl Solution {
    pub fn find_substring(s: String, words: Vec<String>) -> Vec<i32> {
        
        let mut res = Vec::new();
        if s.is_empty() || words.is_empty() {
            return res;
        }
        let mut word_map = std::collections::HashMap::new();
        for w in words.iter() {
            *word_map.entry(w).or_insert(0) += 1;
        }
        let word_len = words[0].len();
        let mut cur_map = std::collections::HashMap::new();
        for i in 0..word_len {
            cur_map.clear();
            let mut left = i;
            let mut right = i;
            let mut count = 0;
            while right + word_len <= s.len() {
                let word = s.get(right..right + word_len).unwrap();
                right += word_len;
                let count = cur_map.entry(word).or_insert(0);
                *count += 1;
                count += 1;
                while *count > *word_map.get(word).unwrap_or(&0) {
                    let left_word = s.get(left..left + word_len).unwrap();
                    left += word_len;
                    let count = cur_map.entry(left_word).or_insert(0);
                    *count -= 1;
                    count -= 1;
                }
                if right - left == word_len * words.len() {
                    res.push(left as i32);
                }
            }
        }
        res
    }
}