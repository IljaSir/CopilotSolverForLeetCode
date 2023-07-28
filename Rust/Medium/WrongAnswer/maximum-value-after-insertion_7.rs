impl Solution {
    pub fn max_value(n: String, x: i32) -> String {
        
        let mut s = String::new();
        let mut flag = false;
        let mut i = 0;
        if n.chars().nth(0).unwrap() == '-' {
            s.push('-');
            i = 1;
        }
        while i < n.len() {
            if (n.chars().nth(i).unwrap() as i32 - '0' as i32) < x && !flag {
                s.push((x + '0' as i32) as u8 as char);
                flag = true;
            }
            s.push(n.chars().nth(i).unwrap());
            i += 1;
        }
        if !flag {
            s.push((x + '0' as i32) as u8 as char);
        }
        s
    }
}