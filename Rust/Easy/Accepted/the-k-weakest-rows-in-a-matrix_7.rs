impl Solution {
    pub fn k_weakest_rows(mat: Vec<Vec<i32>>, k: i32) -> Vec<i32> {
        
        let mut result = Vec::new();
        let mut tmp = Vec::new();
        for (i, row) in mat.iter().enumerate() {
            let mut count = 0;
            for &item in row {
                if item == 1 {
                    count += 1;
                } else {
                    break;
                }
            }
            tmp.push((i, count));
        }
        tmp.sort_by(|&(_, a), &(_, b)| a.cmp(&b));
        for (i, _) in tmp.iter().take(k as usize) {
            result.push(*i as i32);
        }
        result
    }
}