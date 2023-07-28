impl Solution {
    pub fn odd_string(words: Vec<String>) -> String {
        
        let mut res = String::new();
        for i in 0..words.len() {
            let mut count = 0;
            for j in 1..words[i].len() {
                if (words[i].as_bytes()[j] - words[i].as_bytes()[j-1]) % 2 == 0 {
                    count += 1;
                }
            }
            if count == words[i].len() - 1 {
                res = words[i].clone();
                break;
            }
        }
        res
    }
}