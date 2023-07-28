impl Solution {
    pub fn magical_string(n: i32) -> i32 {
        

        let mut s = vec![1, 2, 2];
        let mut i = 2;
        let mut j = 2;
        let mut c = 1;
        while s.len() < n as usize {
            s.push(c);
            if s[i] == 1 {
                if c == 1 {
                    c = 2;
                } else {
                    c = 1;
                }
                s.push(c);
            }
            i += 1;
            j += 1;
        }
        let mut ans = 0;
        for i in 0..n as usize {
            if s[i] == 1 {
                ans += 1;
            }
        }
        ans
    }
}