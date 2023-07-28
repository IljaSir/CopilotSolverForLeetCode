impl Solution {
    pub fn sort_by_bits(arr: Vec<i32>) -> Vec<i32> {
        
        let mut arr: Vec<(i32, i32)> = arr.into_iter().map(|x| (x, x.count_ones())).collect();
        arr.sort_by(|a, b| {
            if a.1 == b.1 {
                a.0.cmp(&b.0)
            } else {
                a.1.cmp(&b.1)
            }
        });
        arr.into_iter().map(|x| x.0).collect()
    }
}