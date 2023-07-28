impl Solution {
    pub fn smallest_number(num: i64) -> i64 {
        
        let mut v: Vec<char> = num.abs().to_string().chars().collect();
        v.sort();
        let mut ret = String::new();
        if num < 0 {
            ret.push('-');
        }
        for c in v {
            if c == '0' && ret.is_empty() {
                continue;
            }
            ret.push(c);
        }
        ret.parse::<i64>().unwrap()
    }
}