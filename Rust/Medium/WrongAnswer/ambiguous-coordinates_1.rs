impl Solution {
    pub fn ambiguous_coordinates(s: String) -> Vec<String> {
        
        let mut res = vec![];
        let s = s.trim_matches(|c| c == '(' || c == ')');
        for i in 1..s.len() {
            let (left, right) = s.split_at(i);
            let l = Self::parse(left);
            let r = Self::parse(right);
            for x in l {
                for y in &r {
                    res.push(format!("({}, {})", x, y));
                }
            }
        }
        res
    }
    fn parse(s: &str) -> Vec<String> {
        let mut res = vec![];
        if s.len() == 1 || s.chars().nth(0).unwrap() != '0' {
            res.push(s.to_string());
        }
        if s.len() > 1 && s.chars().nth(s.len() - 1).unwrap() != '0' {
            for i in 1..s.len() {
                res.push(format!("{}.{}", &s[0..i], &s[i..]));
            }
        }
        res
    }
}