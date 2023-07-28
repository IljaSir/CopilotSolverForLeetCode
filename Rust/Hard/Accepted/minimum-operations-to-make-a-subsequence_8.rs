impl Solution {
    pub fn min_operations(target: Vec<i32>, arr: Vec<i32>) -> i32 {
        
        let mut mp = std::collections::HashMap::new();
        for (i, &t) in target.iter().enumerate() {
            mp.insert(t, i);
        }
        let mut dp = vec![];
        for &a in &arr {
            if let Some(&i) = mp.get(&a) {
                let mut l = 0;
                let mut r = dp.len();
                while l < r {
                    let m = (l + r) / 2;
                    if dp[m] < i {
                        l = m + 1;
                    } else {
                        r = m;
                    }
                }
                if l == dp.len() {
                    dp.push(i);
                } else {
                    dp[l] = i;
                }
            }
        }
        (target.len() - dp.len()) as i32
    }
}