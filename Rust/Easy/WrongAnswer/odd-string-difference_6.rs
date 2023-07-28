impl Solution {
    pub fn odd_string(words: Vec<String>) -> String {
        
        let mut words = words;
        let mut res = String::new();
        let mut diff = vec![];
        for i in 0..words.len() {
            let mut tmp = vec![];
            for j in 0..words[i].len() - 1 {
                tmp.push(words[i].as_bytes()[j + 1] - words[i].as_bytes()[j]);
            }
            diff.push(tmp);
        }
        let mut count = 0;
        for i in 0..diff.len() {
            let mut tmp = 0;
            for j in 0..diff[i].len() {
                tmp += diff[i][j];
            }
            if tmp != 0 {
                count += 1;
                res = words[i].to_string();
            }
        }
        if count == 1 {
            res
        } else {
            String::new()
        }
    }
}