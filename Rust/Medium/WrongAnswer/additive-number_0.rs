impl Solution {
    pub fn is_additive_number(num: String) -> bool {
        

        let num = num.as_bytes();
        let n = num.len();
        let mut a = 0;
        let mut b = 0;
        for i in 0..n {
            a = a * 10 + (num[i] - b'0') as i32;
            b = 0;
            for j in i + 1..n {
                b = b * 10 + (num[j] - b'0') as i32;
                if Self::dfs(&num, j + 1, a, b) {
                    return true;
                }
                if b == 0 {
                    break;
                }
            }
            if a == 0 {
                break;
            }
        }
        false
    }
    fn dfs(num: &[u8], i: usize, a: i32, b: i32) -> bool {
        if i == num.len() {
            return true;
        }
        let mut c = 0;
        for j in i..num.len() {
            c = c * 10 + (num[j] - b'0') as i32;
            if c == a + b && Self::dfs(num, j + 1, b, c) {
                return true;
            }
            if c == 0 {
                break;
            }
        }
        false
    }
}