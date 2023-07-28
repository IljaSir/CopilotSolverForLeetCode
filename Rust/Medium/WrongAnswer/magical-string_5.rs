impl Solution {
    pub fn magical_string(n: i32) -> i32 {
        

        let mut s = vec![1, 2, 2];
        let mut i = 2;
        let mut count = 1;
        while s.len() < n as usize {
            let v = s[i];
            let last = s[s.len() - 1];
            if last == 1 {
                s.push(2);
            } else {
                s.push(1);
                count += 1;
            }
            if v == 2 {
                if last == 1 {
                    s.push(2);
                } else {
                    s.push(1);
                    count += 1;
                }
            }
            i += 1;
        }
        if s.len() == n as usize {
            count
        } else {
            count - (s[s.len() - 1] - (n as usize - s.len() + 1) as i32)
        }
    }
}