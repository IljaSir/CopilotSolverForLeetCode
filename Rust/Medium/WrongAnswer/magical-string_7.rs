impl Solution {
    pub fn magical_string(n: i32) -> i32 {
        

        let mut s = vec![1, 2, 2];
        let mut i = 2;
        let mut j = 0;
        while s.len() < n as usize {
            let x = s[i] ^ 3;
            if s[i] == 2 {
                s.push(x);
                s.push(x);
            } else {
                s.push(x);
            }
            i += 1;
        }
        s[0..n as usize].iter().filter(|&&x| x == 1).count() as i32
    }
}