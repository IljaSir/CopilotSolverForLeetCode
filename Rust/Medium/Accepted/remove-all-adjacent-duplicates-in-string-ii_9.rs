impl Solution {
    pub fn remove_duplicates(s: String, k: i32) -> String {
        
        let mut stack = vec![];
        let mut last = None;
        for c in s.chars() {
            if let Some((ch, cnt)) = last {
                if c == ch {
                    if cnt + 1 == k {
                        last = stack.pop();
                    } else {
                        last = Some((ch, cnt + 1));
                    }
                } else {
                    stack.push(last.unwrap());
                    last = Some((c, 1));
                }
            } else {
                last = Some((c, 1));
            }
        }
        if let Some((ch, cnt)) = last {
            for _ in 0..cnt {
                stack.push((ch, 1));
            }
        }
        let mut result = String::new();
        for (ch, cnt) in stack {
            for _ in 0..cnt {
                result.push(ch);
            }
        }
        result
    }
}