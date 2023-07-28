impl Solution {
    pub fn min_operations(target: Vec<i32>, arr: Vec<i32>) -> i32 {
        
        let mut pos = vec![0; target.len()];
        for (i, v) in target.iter().enumerate() {
            pos[*v as usize - 1] = i;
        }
        let mut d = vec![];
        for v in arr {
            if pos[v as usize - 1] > 0 {
                let p = pos[v as usize - 1];
                if let Err(i) = d.binary_search(&p) {
                    if i > 0 {
                        d[i - 1] = p;
                    } else {
                        d.push(p);
                    }
                }
            }
        }
        (target.len() - d.len()) as i32
    }
}