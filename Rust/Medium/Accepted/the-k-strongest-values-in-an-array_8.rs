impl Solution {
    pub fn get_strongest(arr: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut v = arr.clone();
        v.sort();
        let m = v[(v.len() - 1) / 2];
        let mut v = arr;
        v.sort_by(|a, b| {
            let d1 = (a - m).abs();
            let d2 = (b - m).abs();
            if d1 == d2 {
                b.cmp(a)
            } else {
                d2.cmp(&d1)
            }
        });
        v[0..k as usize].to_vec()
    }
}