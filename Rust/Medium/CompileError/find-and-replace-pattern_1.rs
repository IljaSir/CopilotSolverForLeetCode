impl Solution {
    pub fn find_and_replace_pattern(words: Vec<String>, pattern: String) -> Vec<String> {
        
        let mut result = Vec::new();
        let pattern: Vec<char> = pattern.chars().collect();
        for word in words {
            let word: Vec<char> = word.chars().collect();
            if word.len() != pattern.len() {
                continue;
            }
            let mut map = [0; 26];
            let mut used = [false; 26];
            let mut i = 0;
            for i in 0..word.len() {
                let w = word[i] as usize - 'a' as usize;
                let p = pattern[i] as usize - 'a' as usize;
                if map[p] == 0 {
                    if used[w] {
                        break;
                    }
                    map[p] = w + 1;
                    used[w] = true;
                } else if map[p] != w + 1 {
                    break;
                }
                i += 1;
            }
            if i == word.len() {
                result.push(String::from_utf8(word.iter().map(|c| *c as u8).collect()).unwrap());
            }
        }
        result
    }
}