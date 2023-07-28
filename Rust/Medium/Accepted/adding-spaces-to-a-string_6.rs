impl Solution {
    pub fn add_spaces(s: String, spaces: Vec<i32>) -> String {
        
        let mut res = String::new();
        let mut i = 0;
        for &space in spaces.iter() {
            res += &s[i..space as usize];
            res += " ";
            i = space as usize;
        }
        res += &s[i..];
        res
    }
}