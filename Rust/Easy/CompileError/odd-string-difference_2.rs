impl Solution {
    pub fn odd_string(words: Vec<String>) -> String {
        
        let mut res = String::new();
        let mut diff = Vec::new();
        for word in words {
            let mut temp = Vec::new();
            for i in 1..word.len() {
                temp.push(word.as_bytes()[i] - word.as_bytes()[i-1]);
            }
            diff.push(temp);
        }
        for i in 1..diff.len() {
            if diff[i] != diff[i-1] {
                if i == 1 {
                    res = words[i-1].to_string();
                } else {
                    res = words[i].to_string();
                }
                break;
            }
        }
        res
    }
}