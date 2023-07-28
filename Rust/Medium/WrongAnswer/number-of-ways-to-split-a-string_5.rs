impl Solution {
    pub fn num_ways(s: String) -> i32 {
        
        let s: Vec<char> = s.chars().collect();
        let n = s.len();
        let mut count = 0;
        for c in s.iter() {
            if *c == '1' {
                count += 1;
            }
        }
        if count % 3 != 0 {
            return 0;
        }
        if count == 0 {
            return (((n - 1) as i64) * ((n - 2) as i64) / 2) as i32 % 1000000007;
        }
        let mut i = 0;
        let mut j = 0;
        let mut k = 0;
        let mut sum = 0;
        let mut res = 1;
        while sum < count / 3 {
            if s[i] == '1' {
                sum += 1;
            }
            i += 1;
        }
        while sum < count * 2 / 3 {
            if s[j] == '1' {
                sum += 1;
            }
            j += 1;
        }
        while sum < count {
            if s[k] == '1' {
                sum += 1;
            }
            k += 1;
        }
        res = (i * (n - j) + (n - k) * j - i * (n - k)) as i32 % 1000000007;
        res
    }
}