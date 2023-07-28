impl Solution {
    pub fn find_substring(s: String, words: Vec<String>) -> Vec<i32> {
        
        let s = s.as_bytes();
        let mut ret = Vec::new();
        let mut words_map = std::collections::HashMap::new();
        for word in words {
            *words_map.entry(word).or_insert(0) += 1;
        }
        let word_len = words[0].len();
        let s_len = s.len();
        for i in 0..word_len {
            let mut cur_map = std::collections::HashMap::new();
            let mut left = i;
            let mut right = i;
            let mut count = 0;
            while right + word_len <= s_len {
                let word = std::str::from_utf8(&s[right..right + word_len]).unwrap();
                right += word_len;
                match words_map.get(word) {
                    Some(&v) => {
                        *cur_map.entry(word.to_string()).or_insert(0) += 1;
                        if cur_map[word] <= v {
                            count += 1;
                        }
                        while cur_map[word] > v {
                            let left_word = std::str::from_utf8(&s[left..left + word_len]).unwrap();
                            left += word_len;
                            if cur_map[left_word] <= v {
                                count -= 1;
                            }
                            cur_map.entry(left_word.to_string()).and_modify(|e| *e -= 1);
                        }
                        if count == words.len() {
                            ret.push(left as i32);
                        }
                    }
                    None => {
                        cur_map.clear();
                        left = right;
                        count = 0;
                    }
                }
            }
        }
        ret
    }
}