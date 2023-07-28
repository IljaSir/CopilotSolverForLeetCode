impl Solution {
    pub fn add_spaces(s: String, spaces: Vec<i32>) -> String {
        
        let mut res = String::new();
        let mut i = 0;
        for c in s.chars() {
            if i < spaces.len() && spaces[i] == res.len() as i32 {
                res.push(' ');
                i += 1;
            }
            res.push(c);
        }
        res
    }
}