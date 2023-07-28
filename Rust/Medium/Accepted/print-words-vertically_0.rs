impl Solution {
    pub fn print_vertically(s: String) -> Vec<String> {
        
        let words: Vec<&str> = s.split(' ').collect();
        let max_len = words.iter().map(|s| s.len()).max().unwrap();
        let mut res = vec![];
        for i in 0..max_len {
            let mut s = String::new();
            for j in 0..words.len() {
                if i < words[j].len() {
                    s.push(words[j].chars().nth(i).unwrap());
                } else {
                    s.push(' ');
                }
            }
            while s.ends_with(' ') {
                s.pop();
            }
            res.push(s);
        }
        res
    }
}