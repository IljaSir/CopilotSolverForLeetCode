impl Solution {
    pub fn max_length(arr: Vec<String>) -> i32 {
        
        let mut res = 0;
        let mut paths = vec![0];
        for s in arr {
            let mut mask = 0;
            for c in s.chars() {
                let x = c as usize - 97;
                if (mask >> x) & 1 == 1 {
                    mask = 0;
                    break;
                }
                mask |= 1 << x;
            }
            if mask == 0 {
                continue;
            }
            let n = paths.len();
            for i in 0..n {
                let path = paths[i];
                if path & mask == 0 {
                    res = res.max(path.count_ones() + mask.count_ones());
                    paths.push(path | mask);
                }
            }
        }
        res as i32
    }
}