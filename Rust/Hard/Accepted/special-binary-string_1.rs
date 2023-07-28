impl Solution {
    pub fn make_largest_special(s: String) -> String {
        
        let mut cur = 0;
        let mut start = 0;
        let mut res = Vec::new();
        for (i, c) in s.chars().enumerate() {
            if c == '1' {
                cur += 1;
            } else {
                cur -= 1;
            }
            if cur == 0 {
                res.push("1".to_string() + &Solution::make_largest_special(s[start+1..i].to_string()) + "0");
                start = i + 1;
            }
        }
        res.sort_by(|a, b| b.cmp(a));
        res.join("")
    }
}