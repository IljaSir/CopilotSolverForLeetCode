impl Solution {
    pub fn odd_string(words: Vec<String>) -> String {
        
        let mut res = String::new();
        for i in 0..words.len() {
            let mut odd = true;
            for j in 1..words[i].len() {
                if (words[i].as_bytes()[j] as i32 - words[i].as_bytes()[j-1] as i32) % 2 == 0 {
                    odd = false;
                    break;
                }
            }
            if odd {
                res = words[i].clone();
                break;
            }
        }
        res
    }
}