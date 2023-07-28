impl Solution {
    pub fn count_pairs(deliciousness: Vec<i32>) -> i32 {
        
        let mut m = std::collections::HashMap::new();
        for &d in &deliciousness {
            *m.entry(d).or_insert(0) += 1;
        }
        let mut keys: Vec<_> = m.keys().collect();
        keys.sort();
        let mut res = 0;
        for i in 0..keys.len() {
            for j in i..keys.len() {
                let sum = keys[i] + keys[j];
                if sum & (sum - 1) == 0 {
                    let cnt = m.get(keys[i]).unwrap() * m.get(keys[j]).unwrap();
                    res += if i == j { cnt - 1 } else { cnt };
                }
            }
        }
        (res / 2) as i32 % 1000000007
    }
}