impl Solution {
    pub fn min_operations(target: Vec<i32>, arr: Vec<i32>) -> i32 {
        
        let mut pos = std::collections::HashMap::new();
        for (i, &x) in target.iter().enumerate() {
            pos.insert(x, i);
        }
        let mut d = vec![];
        for &x in arr.iter() {
            if let Some(&i) = pos.get(&x) {
                let p = d.binary_search(&i).unwrap_or_else(|x| x);
                if p < d.len() {
                    d[p] = i;
                } else {
                    d.push(i);
                }
            }
        }
        (target.len() - d.len()) as i32
    }
}