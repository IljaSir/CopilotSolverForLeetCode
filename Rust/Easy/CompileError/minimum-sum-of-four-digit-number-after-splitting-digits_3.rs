impl Solution {
    pub fn minimum_sum(num: i32) -> i32 {
        
        let mut s = num.to_string().chars().collect::<Vec<char>>();
        let mut a = s[0].to_digit(10).unwrap();
        let mut b = s[1].to_digit(10).unwrap();
        let mut c = s[2].to_digit(10).unwrap();
        let mut d = s[3].to_digit(10).unwrap();
        let mut m = 0;
        if a == 0 {
            a = 10;
        }
        if b == 0 {
            b = 10;
        }
        if c == 0 {
            c = 10;
        }
        if d == 0 {
            d = 10;
        }
        if a < b {
            m += a;
            if c < d {
                m += c;
            } else {
                m += d;
            }
        } else {
            m += b;
            if c < d {
                m += c;
            } else {
                m += d;
            }
        }
        return m;
    }
}