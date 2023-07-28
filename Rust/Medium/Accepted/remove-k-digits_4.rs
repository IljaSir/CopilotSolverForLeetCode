impl Solution {
    pub fn remove_kdigits(num: String, k: i32) -> String {
        

        let mut res = String::new();
        let mut k = k;
        for c in num.chars() {
            while k > 0 && res.len() > 0 && res.as_bytes()[res.len() - 1] > c as u8 {
                res.pop();
                k -= 1;
            }
            res.push(c);
        }
        while k > 0 {
            res.pop();
            k -= 1;
        }
        while res.len() > 0 && res.as_bytes()[0] == b'0' {
            res.remove(0);
        }
        if res.len() == 0 {
            res.push('0');
        }
        res
    }
}