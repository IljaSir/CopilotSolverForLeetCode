impl Solution {
    pub fn get_strongest(arr: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut arr = arr;
        arr.sort();
        let m = arr[(arr.len() - 1) / 2];
        arr.sort_by(|a, b| {
            let x = (a - m).abs().cmp(&(b - m).abs());
            if x == std::cmp::Ordering::Equal {
                a.cmp(b)
            } else {
                x
            }
        });
        arr.reverse();
        arr[..k as usize].to_vec()
    }
}