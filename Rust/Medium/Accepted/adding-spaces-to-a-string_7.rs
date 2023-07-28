impl Solution {
    pub fn add_spaces(s: String, spaces: Vec<i32>) -> String {
        
        let mut res = String::new();
        let mut last = 0;
        for i in spaces {
            let i = i as usize;
            res.push_str(&s[last..i]);
            res.push(' ');
            last = i;
        }
        res.push_str(&s[last..]);
        res
    }
}