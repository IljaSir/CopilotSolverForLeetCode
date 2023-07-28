impl Solution {
    pub fn add_spaces(s: String, spaces: Vec<i32>) -> String {
        
        let mut res = String::new();
        let mut i = 0;
        for j in spaces {
            res.push_str(&s[i..j as usize]);
            res.push(' ');
            i = j as usize;
        }
        res.push_str(&s[i..]);
        res
    }
}