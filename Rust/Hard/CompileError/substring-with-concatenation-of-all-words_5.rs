impl Solution {
    pub fn find_substring(s: String, words: Vec<String>) -> Vec<i32> {
        
        if words.is_empty() {
            return Vec::new();
        }
        let mut ans = Vec::new();
        let mut word_map = std::collections::HashMap::new();
        let mut word_len = 0;
        for word in words {
            *word_map.entry(word).or_insert(0) += 1;
            word_len = word.len();
        }
        let word_len = word_len as i32;
        let s_len = s.len() as i32;
        let mut i = 0;
        while i < word_len {
            let mut cur_map = std::collections::HashMap::new();
            let mut count = 0;
            let mut left = i;
            let mut right = i;
            while right + word_len <= s_len {
                let cur_str = s.get((right as usize)..((right + word_len) as usize)).unwrap();
                right += word_len;
                if word_map.contains_key(cur_str) {
                    *cur_map.entry(cur_str.to_string()).or_insert(0) += 1;
                    count += 1;
                    while *cur_map.get(cur_str).unwrap() > *word_map.get(cur_str).unwrap() {
                        let left_str = s.get((left as usize)..((left + word_len) as usize)).unwrap();
                        left += word_len;
                        *cur_map.get_mut(left_str).unwrap() -= 1;
                        count -= 1;
                    }
                    if count == words.len() {
                        ans.push(left);
                    }
                } else {
                    cur_map.clear();
                    count = 0;
                    left = right;
                }
            }
            i += 1;
        }
        ans
    }
}