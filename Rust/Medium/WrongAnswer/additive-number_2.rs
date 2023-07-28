impl Solution {
    pub fn is_additive_number(num: String) -> bool {
        

        let n = num.len();
        if n < 3 { return false; }
        for i in 0..n - 2 {
            for j in i + 1..n - 1 {
                if i > 0 && num.as_bytes()[0] == b'0' { break; }
                if j - i > 1 && num.as_bytes()[i] == b'0' { break; }
                let mut a = num[..i + 1].parse::<i64>().unwrap();
                let mut b = num[i + 1..j + 1].parse::<i64>().unwrap();
                let mut k = j + 1;
                while k < n {
                    let c = a + b;
                    let mut c_str = c.to_string();
                    let c_len = c_str.len();
                    if k + c_len > n || num[k..k + c_len] != c_str { break; }
                    k += c_len;
                    a = b;
                    b = c;
                }
                if k == n { return true; }
            }
        }
        false
    }
}