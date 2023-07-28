impl Solution {
    pub fn min_operations(target: Vec<i32>, arr: Vec<i32>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        for (i, &v) in target.iter().enumerate() {
            map.insert(v, i);
        }
        let mut dp = vec![0];
        for &v in arr.iter() {
            if let Some(&i) = map.get(&v) {
                if let Err(j) = dp.binary_search(&i) {
                    if j == dp.len() {
                        dp.push(i);
                    } else {
                        dp[j] = i;
                    }
                }
            }
        }
        (target.len() - dp.len()) as i32
    }
}