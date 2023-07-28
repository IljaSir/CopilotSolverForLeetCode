impl Solution {
    pub fn delete_string(s: String) -> i32 {
        
        let s: Vec<char> = s.chars().collect();
        let mut i = 0;
        let mut j = s.len() - 1;
        let mut res = 0;
        while i < j {
            let mut k = i + 1;
            while k <= j && s[k] != s[i] {
                k += 1;
            }
            if k > j {
                res += 1;
                break;
            }
            if k - i == j - k + 1 {
                res += 2;
                break;
            }
            if k - i > j - k + 1 {
                res += 1;
                j = k - 2;
            } else {
                res += 1;
                i = k;
            }
        }
        res
    }
}