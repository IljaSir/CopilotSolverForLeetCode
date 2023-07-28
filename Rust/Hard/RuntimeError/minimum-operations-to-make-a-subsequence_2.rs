impl Solution {
    pub fn min_operations(target: Vec<i32>, arr: Vec<i32>) -> i32 {
        
        let mut pos = vec![0; target.len()];
        for (i, &x) in target.iter().enumerate() {
            pos[x as usize - 1] = i;
        }
        let mut d = Vec::new();
        for &x in arr.iter() {
            let idx = pos[x as usize - 1];
            if idx > 0 {
                let p = d.binary_search(&idx).unwrap_or_else(|x| x);
                if p == d.len() {
                    d.push(idx);
                } else {
                    d[p] = idx;
                }
            }
        }
        (target.len() - d.len()) as i32
    }
}