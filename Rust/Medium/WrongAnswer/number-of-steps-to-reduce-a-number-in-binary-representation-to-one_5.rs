impl Solution {
    pub fn num_steps(s: String) -> i32 {
        
        let mut num = s;
        let mut step = 0;
        while num != "1" {
            if num.ends_with("0") {
                num.pop();
            } else {
                let mut i = num.len() - 1;
                while i > 0 && num.chars().nth(i).unwrap() == '1' {
                    num.replace_range(i..i+1, "0");
                    i -= 1;
                }
                if i == 0 && num.chars().nth(i).unwrap() == '1' {
                    num.replace_range(i..i+1, "0");
                    num.insert(0, '1');
                }
            }
            step += 1;
        }
        step
    }
}