impl Solution {
    pub fn minimum_length_encoding(words: Vec<String>) -> i32 {
        
        let mut words = words;
        let mut res = 0;
        words.sort_by(|a, b| b.len().cmp(&a.len()));
        for i in 0..words.len() {
            let mut flag = true;
            for j in i + 1..words.len() {
                if words[j].ends_with(&words[i]) {
                    flag = false;
                    break;
                }
            }
            if flag {
                res += words[i].len() + 1;
            }
        }
        res as i32
    }
}