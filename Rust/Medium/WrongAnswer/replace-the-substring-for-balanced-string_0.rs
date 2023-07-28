impl Solution {
    pub fn balanced_string(s: String) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        for c in s.chars() {
            *map.entry(c).or_insert(0) += 1;
        }
        let mut l = 0;
        let mut r = 0;
        let mut res = s.len() as i32;
        let mut count = 0;
        let n = s.len() as i32;
        while r < n {
            let cur = map.entry(s.chars().nth(r as usize).unwrap()).or_insert(0);
            *cur -= 1;
            if *cur >= 0 {
                count += 1;
            }
            while count == n / 4 {
                let c = s.chars().nth(l as usize).unwrap();
                res = res.min(r - l + 1);
                let cur = map.entry(c).or_insert(0);
                *cur += 1;
                if *cur > 0 {
                    count -= 1;
                }
                l += 1;
            }
            r += 1;
        }
        res
    }
}