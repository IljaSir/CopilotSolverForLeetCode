impl Solution {
    pub fn smallest_number(num: i64) -> i64 {
        
        let mut s = num.abs().to_string().chars().collect::<Vec<char>>();
        s.sort();
        let mut res = String::new();
        for i in 0..s.len() {
            if s[i] != '0' {
                res.push(s[i]);
                res.push_str(&s[i+1..].iter().collect::<String>());
                break;
            }
        }
        if num < 0 {
            -(res.parse::<i64>().unwrap())
        } else {
            res.parse::<i64>().unwrap()
        }
    }
}