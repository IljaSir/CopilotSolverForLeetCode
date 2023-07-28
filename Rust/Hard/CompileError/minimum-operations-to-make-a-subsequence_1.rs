impl Solution {
    pub fn min_operations(target: Vec<i32>, arr: Vec<i32>) -> i32 {
        
        let mut pos = vec![0; target.len()];
        for (i, &x) in target.iter().enumerate() {
            pos[x as usize - 1] = i;
        }
        let mut d = vec![];
        for &x in arr.iter() {
            let p = pos[x as usize - 1];
            if p > 0 {
                let idx = d.lower_bound(&p);
                if idx == d.len() {
                    d.push(p);
                } else {
                    d[idx] = p;
                }
            }
        }
        target.len() as i32 - d.len() as i32
    }
}