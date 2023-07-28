impl Solution {
    pub fn largest_palindromic(num: String) -> String {
        
        let n = num.len();
        let mut chars = num.chars().collect::<Vec<char>>();
        chars.sort_by(|a, b| b.cmp(a));
        let mut s = String::new();
        for i in 0..n {
            s.push(chars[i]);
        }
        s
    }
}