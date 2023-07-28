impl Solution {
    pub fn odd_string(words: Vec<String>) -> String {
        
        let mut ret = String::new();
        let mut diff = Vec::new();
        for word in words {
            let mut tmp = Vec::new();
            for (i, c) in word.chars().enumerate() {
                if i != 0 {
                    tmp.push(c as i32 - word.chars().nth(i - 1).unwrap() as i32);
                }
            }
            if diff.contains(&tmp) {
                diff.retain(|x| x != &tmp);
            } else {
                diff.push(tmp);
            }
        }
        for word in words {
            let mut tmp = Vec::new();
            for (i, c) in word.chars().enumerate() {
                if i != 0 {
                    tmp.push(c as i32 - word.chars().nth(i - 1).unwrap() as i32);
                }
            }
            if tmp == diff[0] {
                ret = word;
                break;
            }
        }
        ret
    }
}