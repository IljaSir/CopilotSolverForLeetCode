impl Solution {
    pub fn add_spaces(s: String, spaces: Vec<i32>) -> String {
        
        let mut res = String::new();
        let mut j = 0;
        for i in 0..s.len() {
            res.push(s.chars().nth(i).unwrap());
            if j < spaces.len() && i == spaces[j] as usize {
                res.push(' ');
                j += 1;
            }
        }
        res
    }
}