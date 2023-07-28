impl Solution {
    pub fn get_strongest(arr: Vec<i32>, k: i32) -> Vec<i32> {
        
        let n = arr.len();
        let mut arr = arr;
        arr.sort_unstable();
        let m = arr[(n - 1) / 2];
        arr.sort_unstable_by(|a, b| {
            let d1 = (a - m).abs();
            let d2 = (b - m).abs();
            if d1 > d2 {
                std::cmp::Ordering::Less
            } else if d1 < d2 {
                std::cmp::Ordering::Greater
            } else {
                b.cmp(a)
            }
        });
        arr.truncate(k as usize);
        arr
    }
}