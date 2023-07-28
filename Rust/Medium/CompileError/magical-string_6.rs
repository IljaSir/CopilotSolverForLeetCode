impl Solution {
    pub fn magical_string(n: i32) -> i32 {
        

        let mut s = vec![1, 2, 2];
        let mut i = 2;
        let mut j = 3;
        let mut res = 0;
        while j < n {
            s.push((s[i] ^ 3) - 1);
            if s[i] == 1 {
                res += 1;
            }
            if s[j] == 1 {
                res += 1;
            }
            i += 1;
            j += 1;
        }
        if j == n && s[i] == 1 {
            res += 1;
        }
        res
    }
}