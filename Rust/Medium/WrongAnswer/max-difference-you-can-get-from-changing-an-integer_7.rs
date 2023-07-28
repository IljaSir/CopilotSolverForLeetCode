impl Solution {
    pub fn max_diff(num: i32) -> i32 {
        
        let mut s = num.to_string();
        let mut a = s.clone();
        let mut b = s.clone();
        if s.contains('0') {
            s = s.replace('0', "1");
            a = a.replace('0', "1");
            b = b.replace('0', "1");
        } else {
            s = s.replace(s.chars().nth(0).unwrap(), "1");
            a = a.replace(a.chars().nth(0).unwrap(), "0");
            b = b.replace(b.chars().nth(0).unwrap(), "1");
        }
        s.parse::<i32>().unwrap() - a.parse::<i32>().unwrap()
    }
}