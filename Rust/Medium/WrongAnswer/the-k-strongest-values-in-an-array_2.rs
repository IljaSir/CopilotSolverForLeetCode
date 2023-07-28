impl Solution {
    pub fn get_strongest(arr: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut arr = arr;
        arr.sort_unstable();
        let mid = if arr.len() % 2 == 0 {
            (arr[arr.len() / 2 - 1] + arr[arr.len() / 2]) / 2
        } else {
            arr[arr.len() / 2]
        };
        arr.sort_unstable_by(|a, b| {
            let diff_a = (a - mid).abs();
            let diff_b = (b - mid).abs();
            if diff_a == diff_b {
                b.cmp(a)
            } else {
                diff_b.cmp(&diff_a)
            }
        });
        arr.truncate(k as usize);
        arr
    }
}