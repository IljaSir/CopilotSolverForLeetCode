impl Solution {
    pub fn largest_palindromic(num: String) -> String {
        
        let num: Vec<u8> = num.bytes().map(|x| x - b'0').collect();
        let n = num.len();
        let mut res = String::new();
        for i in (0..n).rev() {
            let mut j = i;
            while j < n && num[i] == num[j] {
                j += 1;
            }
            let mut k = i;
            while k > 0 && j < n && num[k - 1] == num[j] {
                k -= 1;
                j += 1;
            }
            if j - k > res.len() {
                res = String::from_utf8_lossy(&num[k..j]).to_string();
            }
        }
        res
    }
}