impl Solution {
    pub fn avoid_flood(rains: Vec<i32>) -> Vec<i32> {
        
        let mut ans = vec![-1; rains.len()];
        let mut lakes = std::collections::HashMap::new();
        let mut dry_lakes = std::collections::BTreeSet::new();
        for (i, &lake) in rains.iter().enumerate() {
            if lake == 0 {
                dry_lakes.insert(i);
            } else {
                if let Some(&j) = lakes.get(&lake) {
                    if let Some(&k) = dry_lakes.range(j..).next() {
                        ans[k] = lake;
                        dry_lakes.remove(&k);
                    } else {
                        return vec![];
                    }
                }
                ans[i] = -1;
                lakes.insert(lake, i);
            }
        }
        ans
    }
}