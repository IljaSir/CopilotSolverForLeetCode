impl Solution {
    pub fn min_operations(target: Vec<i32>, arr: Vec<i32>) -> i32 {
        
        let mut m = std::collections::HashMap::new();
        for (i, &v) in target.iter().enumerate() {
            m.insert(v, i);
        }
        let mut v = Vec::new();
        for &v1 in arr.iter() {
            if let Some(&v2) = m.get(&v1) {
                if let Some(&v3) = v.last() {
                    if v3 < v2 {
                        v.push(v2);
                    } else {
                        let i = v.binary_search(&v2).unwrap_err();
                        v[i] = v2;
                    }
                } else {
                    v.push(v2);
                }
            }
        }
        (target.len() - v.len()) as i32
    }
}