impl Solution {
    pub fn add_strings(num1: String, num2: String) -> String {
        
        let mut c = 0;
        let mut ret = String::new();
        let mut i = num1.len();
        let mut j = num2.len();
        while i > 0 || j > 0 {
            let mut v = c;
            if i > 0 {
                i -= 1;
                v += num1.chars().nth(i).unwrap().to_digit(10).unwrap();
            }
            if j > 0 {
                j -= 1;
                v += num2.chars().nth(j).unwrap().to_digit(10).unwrap();
            }
            c = v / 10;
            ret.push_str(&(v % 10).to_string());
        }
        if c > 0 {
            ret.push_str(&c.to_string());
        }
        ret.chars().rev().collect()
    }
}