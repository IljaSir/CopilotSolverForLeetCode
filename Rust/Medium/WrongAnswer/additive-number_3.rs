impl Solution {
    pub fn is_additive_number(num: String) -> bool {
        

        let num = num.as_bytes();
        let n = num.len();
        let mut a = 0;
        let mut b = 0;
        for i in 0..n/2 {
            a = a * 10 + (num[i] - b'0') as i64;
            b = 0;
            for j in i+1..n {
                b = b * 10 + (num[j] - b'0') as i64;
                if Self::dfs(num, n, j+1, a, b) {
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
    pub fn dfs(num: &[u8], n: usize, i: usize, a: i64, b: i64) -> bool {
        if i == n {
            return true;
        }
        let c = a + b;
        let mut k = i;
        let mut x = 0;
        while k < n && x < c {
            x = x * 10 + (num[k] - b'0') as i64;
            k += 1;
        }
        if x == c {
            return Self::dfs(num, n, k, b, c);
        }
        false
    }
}