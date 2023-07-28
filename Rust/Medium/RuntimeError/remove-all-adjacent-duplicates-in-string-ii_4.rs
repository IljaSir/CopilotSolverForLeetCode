impl Solution {
    pub fn remove_duplicates(s: String, k: i32) -> String {
        
        let mut stack: Vec<(char, i32)> = Vec::new();
        for c in s.chars() {
            if let Some(&mut (ref mut cc, ref mut count)) = stack.last_mut() {
                if *cc == c {
                    *count += 1;
                } else {
                    stack.push((c, 1));
                }
            } else {
                stack.push((c, 1));
            }
            while stack.last().unwrap().1 >= k {
                stack.pop();
            }
        }
        let mut res = String::new();
        for (c, count) in stack {
            res.push_str(&c.to_string().repeat(count as usize));
        }
        res
    }
}