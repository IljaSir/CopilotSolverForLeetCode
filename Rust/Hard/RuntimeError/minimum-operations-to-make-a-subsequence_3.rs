impl Solution {
    pub fn min_operations(target: Vec<i32>, arr: Vec<i32>) -> i32 {
        
        let mut pos = vec![0; target.len()];
        for i in 0..target.len() {
            pos[target[i] as usize - 1] = i as i32;
        }
        let mut d = vec![];
        for i in arr {
            if pos[i as usize - 1] > 0 {
                let idx = d.binary_search(&pos[i as usize - 1]).unwrap_or_else(|x| x);
                if idx == d.len() {
                    d.push(pos[i as usize - 1]);
                } else {
                    d[idx] = pos[i as usize - 1];
                }
            }
        }
        target.len() as i32 - d.len() as i32
    }
}