impl Solution {
    pub fn add_spaces(s: String, spaces: Vec<i32>) -> String {
        
        let mut res = String::new();
        let mut i = 0;
        for &space in spaces.iter() {
            res.push_str(&s[i..space as usize]);
            res.push(' ');
            i = space as usize;
        }
        res.push_str(&s[i..]);
        res
    }
}