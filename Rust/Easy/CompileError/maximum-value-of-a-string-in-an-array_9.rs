impl Solution {
    pub fn maximum_value(strs: Vec<String>) -> i32 {
        
        let mut res = 0;
        for s in strs {
            let mut num = 0;
            let mut is_digit = true;
            for c in s.chars() {
                if c.is_digit(10) {
                    num = num * 10 + c.to_digit(10).unwrap();
                } else {
                    is_digit = false;
                    break;
                }
            }
            if is_digit {
                res = res.max(num);
            } else {
                res = res.max(s.len() as i32);
            }
        }
        res
    }
}