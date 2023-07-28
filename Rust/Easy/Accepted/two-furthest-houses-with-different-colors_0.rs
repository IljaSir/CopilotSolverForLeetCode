impl Solution {
    pub fn max_distance(colors: Vec<i32>) -> i32 {
        
        let mut first = vec![-1; 101];
        let mut last = vec![-1; 101];
        let n = colors.len();
        for i in 0..n {
            let c = colors[i] as usize;
            if first[c] == -1 {
                first[c] = i as i32;
            }
            last[c] = i as i32;
        }
        let mut res = 0;
        for i in 0..101 {
            for j in (i+1)..101 {
                if first[i] != -1 && first[j] != -1 {
                    res = res.max((last[i] - first[j]).abs());
                    res = res.max((last[j] - first[i]).abs());
                }
            }
        }
        res
    }
}