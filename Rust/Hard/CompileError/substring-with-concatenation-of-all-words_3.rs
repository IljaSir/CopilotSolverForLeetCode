impl Solution {
    pub fn find_substring(s: String, words: Vec<String>) -> Vec<i32> {
        
        let mut ans = vec![];
        if words.len() == 0 {
            return ans;
        }
        let len = words[0].len();
        let total_len = len * words.len();
        let mut map = std::collections::HashMap::new();
        let mut tmp = vec![];
        for word in words {
            let count = map.entry(word.clone()).or_insert(0);
            *count += 1;
            tmp.push(word);
        }
        for i in 0..s.len() - total_len + 1 {
            let mut map = map.clone();
            let mut ok = true;
            for j in 0..words.len() {
                let word = s[i + j * len..i + (j + 1) * len].to_string();
                if let Some(count) = map.get_mut(&word) {
                    *count -= 1;
                    if *count == 0 {
                        map.remove(&word);
                    }
                } else {
                    ok = false;
                    break;
                }
            }
            if ok {
                ans.push(i as i32);
            }
        }
        ans
    }
}