impl Solution {
    pub fn k_weakest_rows(mat: Vec<Vec<i32>>, k: i32) -> Vec<i32> {
        
        let mut ret = Vec::new();
        let mut tmp = Vec::new();
        for (i, v) in mat.iter().enumerate() {
            let mut count = 0;
            for &t in v {
                if t == 1 {
                    count += 1;
                } else {
                    break;
                }
            }
            tmp.push((i, count));
        }
        tmp.sort_by(|a, b| {
            if a.1 == b.1 {
                a.0.cmp(&b.0)
            } else {
                a.1.cmp(&b.1)
            }
        });
        for i in 0..k {
            ret.push(tmp[i as usize].0 as i32);
        }
        ret
    }
}