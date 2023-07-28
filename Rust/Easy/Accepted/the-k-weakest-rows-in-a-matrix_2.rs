impl Solution {
    pub fn k_weakest_rows(mat: Vec<Vec<i32>>, k: i32) -> Vec<i32> {
        
        let mut rows = mat
            .into_iter()
            .enumerate()
            .map(|(i, row)| (i, row.iter().filter(|&&x| x == 1).count()))
            .collect::<Vec<(usize, usize)>>();
        rows.sort_by_key(|&(_, count)| count);
        rows.into_iter().map(|(i, _)| i as i32).take(k as usize).collect()
    }
}