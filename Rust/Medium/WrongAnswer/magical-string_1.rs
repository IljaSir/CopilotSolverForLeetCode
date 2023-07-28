impl Solution {
    pub fn magical_string(n: i32) -> i32 {
        

        let n = n as usize;
        let mut s = vec![1, 2, 2];
        let mut i = 2;
        let mut res = 0;
        while s.len() < n {
            let last = s.last().unwrap();
            if last == &1 {
                let next = if s[i] == 1 { 2 } else { 1 };
                s.push(next);
                if next == 1 && s.len() <= n {
                    res += 1;
                }
            } else {
                let next = if s[i] == 1 { 2 } else { 1 };
                s.push(next);
                if next == 1 && s.len() <= n {
                    res += 1;
                }
                s.push(next);
                if next == 1 && s.len() <= n {
                    res += 1;
                }
            }
            i += 1;
        }
        res
    }
}