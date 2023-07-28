impl Solution {
    pub fn max_diff(num: i32) -> i32 {
        
        let s = num.to_string();
        let mut a = s.clone();
        let mut b = s.clone();
        let mut a_max = 0;
        let mut b_min = 9;
        for i in 0..a.len() {
            let c = a.chars().nth(i).unwrap();
            if c == '9' {
                a_max = 9;
                continue;
            }
            a_max = a_max.max(c.to_digit(10).unwrap() as i32);
            a = a.replace(c, "9");
        }
        for i in 0..b.len() {
            let c = b.chars().nth(i).unwrap();
            if c == '1' {
                b_min = 1;
                continue;
            }
            if c == '0' {
                continue;
            }
            b_min = b_min.min(c.to_digit(10).unwrap() as i32);
            b = b.replace(c, "1");
        }
        if b_min == 9 {
            b_min = 1;
        }
        a.parse::<i32>().unwrap() - b.parse::<i32>().unwrap()
    }
}