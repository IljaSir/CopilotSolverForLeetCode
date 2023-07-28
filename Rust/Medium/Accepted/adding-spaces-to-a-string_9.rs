impl Solution {
    pub fn add_spaces(s: String, spaces: Vec<i32>) -> String {
        
        let mut ans = String::new();
        let mut i = 0;
        let mut j = 0;
        for c in s.chars() {
            if i < spaces.len() && spaces[i] == j {
                ans.push(' ');
                i += 1;
            }
            ans.push(c);
            j += 1;
        }
        ans
    }
}