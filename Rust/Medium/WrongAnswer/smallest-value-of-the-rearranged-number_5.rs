impl Solution {
    pub fn smallest_number(num: i64) -> i64 {
        
        let mut s = num.to_string().chars().collect::<Vec<char>>();
        s.sort();
        let mut r = String::new();
        for i in 0..s.len() {
            if s[i] != '0' {
                r.push(s[i]);
                s.remove(i);
                break;
            }
        }
        r.push_str(&s.iter().collect::<String>());
        r.parse::<i64>().unwrap()
    }
}