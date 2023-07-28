impl Solution {
    pub fn reverse_words(s: String) -> String {
        
        let mut res = String::new();
        let mut temp = String::new();
        for c in s.chars() {
            if c == ' ' {
                res.push_str(&(temp.chars().rev().collect::<String>()));
                res.push(' ');
                temp.clear();
            } else {
                temp.push(c);
            }
        }
        res.push_str(&(temp.chars().rev().collect::<String>()));
        res
    }
}