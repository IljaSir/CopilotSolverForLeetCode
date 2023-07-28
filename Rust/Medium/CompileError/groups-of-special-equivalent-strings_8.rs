impl Solution {
    pub fn num_special_equiv_groups(words: Vec<String>) -> i32 {
        
        let mut v: Vec<Vec<usize>> = words.iter().map(|s| s.chars().enumerate().map(|(i, c)| (c as usize, i % 2)).collect()).collect();
        v.sort_by(|a, b| {
            for i in 0..a.len() {
                if a[i].0 != b[i].0 {
                    return a[i].0.cmp(&b[i].0);
                }
                if a[i].1 != b[i].1 {
                    return a[i].1.cmp(&b[i].1);
                }
            }
            std::cmp::Ordering::Equal
        });
        let mut ans = 1;
        for i in 1..v.len() {
            if v[i] != v[i - 1] {
                ans += 1;
            }
        }
        ans
    }
}