impl Solution {
    pub fn largest_variance(s: String) -> i32 {
        
        let mut res = 0;
        let mut count = vec![0; 26];
        for c in s.chars() {
            let i = c as usize - 'a' as usize;
            count[i] += 1;
            let mut min = 100001;
            let mut max = 0;
            for &c in count.iter() {
                if c > 0 {
                    min = min.min(c);
                    max = max.max(c);
                }
            }
            res = res.max(max - min);
        }
        res
    }
}