impl Solution {
    pub fn find_substring(s: String, words: Vec<String>) -> Vec<i32> {
        
        let mut res = vec![];
        if words.is_empty() {
            return res;
        }
        let n = s.len();
        let m = words.len();
        let w = words[0].len();
        let mut map = std::collections::HashMap::new();
        for word in words {
            *map.entry(word).or_insert(0) += 1;
        }
        for i in 0..w {
            let mut left = i;
            let mut right = i;
            let mut count = 0;
            let mut cur_map = std::collections::HashMap::new();
            while right + w <= n {
                let word = s[right..right+w].to_string();
                right += w;
                if !map.contains_key(&word) {
                    count = 0;
                    cur_map.clear();
                    left = right;
                } else {
                    *cur_map.entry(word).or_insert(0) += 1;
                    count += 1;
                    while *cur_map.get(&word).unwrap() > *map.get(&word).unwrap() {
                        let word = s[left..left+w].to_string();
                        left += w;
                        count -= 1;
                        *cur_map.get_mut(&word).unwrap() -= 1;
                    }
                    if count == m {
                        res.push(left as i32);
                        let word = s[left..left+w].to_string();
                        left += w;
                        count -= 1;
                        *cur_map.get_mut(&word).unwrap() -= 1;
                    }
                }
            }
        }
        res
    }
}