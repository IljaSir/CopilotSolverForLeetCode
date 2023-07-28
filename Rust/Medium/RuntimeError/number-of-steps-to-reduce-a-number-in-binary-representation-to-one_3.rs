impl Solution {
    pub fn num_steps(s: String) -> i32 {
        
        let mut steps = 0;
        let mut s = s;
        while s != "1" {
            steps += 1;
            if s.chars().last().unwrap() == '1' {
                s = format!("{:b}", i32::from_str_radix(&s, 2).unwrap() + 1);
            } else {
                s = s[0..s.len() - 1].to_string();
            }
        }
        steps
    }
}