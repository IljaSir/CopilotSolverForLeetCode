impl Solution {
    pub fn smallest_number(num: i64) -> i64 {
        
        let mut v = num.abs().to_string().chars().collect::<Vec<char>>();
        v.sort();
        let mut r = String::new();
        for c in v {
            r.push(c);
        }
        let mut s = r.parse::<i64>().unwrap();
        if num < 0 {
            s = -s;
        }
        s
    }
}