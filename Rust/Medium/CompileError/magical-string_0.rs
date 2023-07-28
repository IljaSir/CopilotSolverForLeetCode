impl Solution {
    pub fn magical_string(n: i32) -> i32 {
        

        if n == 0 {
            return 0;
        }
        if n <= 3 {
            return 1;
        }
        let mut s = vec![1, 2, 2];
        let mut i = 2;
        let mut j = 3;
        let mut res = 1;
        while j < n {
            let c = s[i];
            let last = s[j - 1];
            if last == 1 {
                if c == 1 {
                    res += 1;
                }
                s.push(2);
            } else {
                if c == 1 {
                    res += 1;
                }
                s.push(2);
                if c == 1 {
                    res += 1;
                }
                s.push(2);
            }
            i += 1;
            j += 1;
        }
        res
    }
}