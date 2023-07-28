impl Solution {
    pub fn add_spaces(s: String, spaces: Vec<i32>) -> String {
        
        let mut result = String::new();
        let mut i = 0;
        for space in spaces {
            let space = space as usize;
            result.push_str(&s[i..space]);
            result.push(' ');
            i = space;
        }
        result.push_str(&s[i..]);
        result
    }
}