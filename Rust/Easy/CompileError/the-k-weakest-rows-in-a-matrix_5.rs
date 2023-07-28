impl Solution {
    pub fn k_weakest_rows(mat: Vec<Vec<i32>>, k: i32) -> Vec<i32> {
        
        let mut soldiers = Vec::new();
        for row in mat.iter() {
            let mut count = 0;
            for &v in row.iter() {
                if v == 1 {
                    count += 1;
                } else {
                    break;
                }
            }
            soldiers.push(count);
        }
        let mut rows = Vec::new();
        for i in 0..soldiers.len() {
            rows.push(i);
        }
        rows.sort_by_key(|&i| (soldiers[i], i));
        rows[..k as usize].to_vec()
    }
}