impl Solution {
    pub fn find_substring(s: String, words: Vec<String>) -> Vec<i32> {
        
        let mut ans = vec![];
        let mut word_map = std::collections::HashMap::new();
        for word in words {
            *word_map.entry(word).or_insert(0) += 1;
        }
        let word_len = words[0].len();
        for i in 0..word_len {
            let mut left = i;
            let mut right = i;
            let mut cur_map = std::collections::HashMap::new();
            while right + word_len <= s.len() {
                let word = &s[right..right + word_len];
                right += word_len;
                *cur_map.entry(word.to_string()).or_insert(0) += 1;
                while *cur_map.get(word).unwrap() > *word_map.get(word).unwrap() {
                    let left_word = &s[left..left + word_len];
                    left += word_len;
                    cur_map.entry(left_word.to_string()).and_modify(|e| *e -= 1);
                }
                if right - left == word_len * words.len() {
                    ans.push(left as i32);
                }
            }
        }
        ans
    }
}