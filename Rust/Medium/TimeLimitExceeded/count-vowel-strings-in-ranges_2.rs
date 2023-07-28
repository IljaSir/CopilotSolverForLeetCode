impl Solution {
    pub fn vowel_strings(words: Vec<String>, queries: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut ans = Vec::new();
        let words: Vec<&str> = words.iter().map(|s| s.as_str()).collect();
        for q in queries {
            let mut cnt = 0;
            for i in q[0] as usize..=q[1] as usize {
                let s = words[i];
                if s.starts_with("a") || s.starts_with("e") || s.starts_with("i") || s.starts_with("o") || s.starts_with("u") {
                    if s.ends_with("a") || s.ends_with("e") || s.ends_with("i") || s.ends_with("o") || s.ends_with("u") {
                        cnt += 1;
                    }
                }
            }
            ans.push(cnt);
        }
        ans
    }
}