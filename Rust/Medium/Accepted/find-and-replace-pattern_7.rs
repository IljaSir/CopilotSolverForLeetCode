impl Solution {
    pub fn find_and_replace_pattern(words: Vec<String>, pattern: String) -> Vec<String> {
        
        let mut res = Vec::new();
        for word in words {
            let w = word.as_bytes();
            let p = pattern.as_bytes();
            let mut map = [0; 26];
            let mut used = [false; 26];
            let mut i = 0;
            while i < w.len() {
                let wi = w[i] - b'a';
                let pi = p[i] - b'a';
                if map[wi as usize] == 0 {
                    if used[pi as usize] {
                        break;
                    }
                    map[wi as usize] = pi + 1;
                    used[pi as usize] = true;
                } else if map[wi as usize] != pi + 1 {
                    break;
                }
                i += 1;
            }
            if i == w.len() {
                res.push(word);
            }
        }
        res
    }
}