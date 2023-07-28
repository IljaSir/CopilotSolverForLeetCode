impl Solution {
    pub fn is_additive_number(num: String) -> bool {
        

        let num = num.as_bytes();
        let n = num.len();
        for i in 0..n {
            for j in i+1..n {
                let mut a = num[..i+1].to_vec();
                let mut b = num[i+1..j+1].to_vec();
                if a[0] == b'0' && a.len() > 1 { continue; }
                if b[0] == b'0' && b.len() > 1 { continue; }
                if Self::check(&a, &b, &num[j+1..]) { return true; }
            }
        }
        false
    }
    fn check(a: &[u8], b: &[u8], c: &[u8]) -> bool {
        if c.is_empty() { return true; }
        let mut sum = vec![];
        let mut carry = 0;
        let mut i = a.len();
        let mut j = b.len();
        while i > 0 || j > 0 {
            let x = if i > 0 { a[i-1] - b'0' } else { 0 };
            let y = if j > 0 { b[j-1] - b'0' } else { 0 };
            let s = x + y + carry;
            sum.push(b'0' + s % 10);
            carry = s / 10;
            i -= 1;
            j -= 1;
        }
        if carry > 0 { sum.push(b'0' + carry); }
        sum.reverse();
        if c.starts_with(&sum) {
            Self::check(b, &sum, &c[sum.len()..])
        } else {
            false
        }
    }
}