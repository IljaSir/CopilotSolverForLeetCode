impl Solution {
    pub fn largest_palindromic(num: String) -> String {
        
        if num == "9" {
            return "9".to_string();
        }
        let num: Vec<u8> = num.as_bytes().iter().map(|&x| x - b'0').collect();
        let n = num.len();
        let mut res = 0;
        let mut a = 0;
        let mut b = 0;
        for i in (0..n).rev() {
            a = a * 10 + num[i] as i32;
            b = 0;
            for j in (0..10).rev() {
                b = b * 10 + j;
                let c = a * b;
                if c > res && c < 10i32.pow(n as u32) && c / b == a && c / a == b {
                    res = c;
                }
            }
        }
        res.to_string()
    }
}