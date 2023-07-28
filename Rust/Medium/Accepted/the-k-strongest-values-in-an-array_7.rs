impl Solution {
    pub fn get_strongest(arr: Vec<i32>, k: i32) -> Vec<i32> {
        
        let n = arr.len();
        let mut arr = arr;
        let mut k = k as usize;
        arr.sort();
        let mid = arr[(n - 1) / 2];
        arr.sort_by(|a, b| {
            let diff_a = (a - mid).abs();
            let diff_b = (b - mid).abs();
            if diff_a == diff_b {
                b.cmp(a)
            } else {
                diff_b.cmp(&diff_a)
            }
        });
        arr.truncate(k);
        arr
    }
}