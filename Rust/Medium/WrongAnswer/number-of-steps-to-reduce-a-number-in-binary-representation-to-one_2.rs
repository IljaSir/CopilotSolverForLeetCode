impl Solution {
    pub fn num_steps(s: String) -> i32 {
        
        let mut s = s;
        let mut count = 0;
        while s != "1" {
            if s.chars().last().unwrap() == '0' {
                s.pop();
            } else {
                let mut i = s.len() - 1;
                while i > 0 && s.chars().nth(i).unwrap() == '1' {
                    s.remove(i);
                    i -= 1;
                }
                if i == 0 {
                    s.remove(i);
                } else {
                    s.remove(i);
                }
                s.push('1');
            }
            count += 1;
        }
        count
    }
}