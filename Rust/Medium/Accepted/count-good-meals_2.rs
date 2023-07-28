impl Solution {
    pub fn count_pairs(deliciousness: Vec<i32>) -> i32 {
        
        let mut m = std::collections::HashMap::new();
        let mut ans = 0;
        let mut i = 0;
        while i < deliciousness.len() {
            let mut j = 0;
            while j <= 21 {
                let t = 1 << j;
                if let Some(v) = m.get(&(t - deliciousness[i])) {
                    ans += v;
                    ans %= 1000000007;
                }
                j += 1;
            }
            *m.entry(deliciousness[i]).or_insert(0) += 1;
            i += 1;
        }
        ans as i32
    }
}