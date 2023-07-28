impl Solution {
    pub fn get_happy_string(n: i32, k: i32) -> String {
        
        let mut res = String::new();
        if k > 3 * 2_i32.pow(n as u32 - 1) {
            return res;
        }
        let mut k = k - 1;
        let mut n = n as usize;
        let mut prev = ' ';
        while n > 0 {
            let mut c = k / 2_i32.pow(n as u32 - 1) as i32;
            k %= 2_i32.pow(n as u32 - 1) as i32;
            if prev == 'a' {
                if c == 0 {
                    res.push('b');
                    prev = 'b';
                } else {
                    res.push('c');
                    prev = 'c';
                }
            } else if prev == 'b' {
                if c == 0 {
                    res.push('a');
                    prev = 'a';
                } else {
                    res.push('c');
                    prev = 'c';
                }
            } else {
                if c == 0 {
                    res.push('a');
                    prev = 'a';
                } else {
                    res.push('b');
                    prev = 'b';
                }
            }
            n -= 1;
        }
        res
    }
}