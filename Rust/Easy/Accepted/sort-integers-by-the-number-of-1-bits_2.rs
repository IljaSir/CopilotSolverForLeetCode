impl Solution {
    pub fn sort_by_bits(arr: Vec<i32>) -> Vec<i32> {
        
        let mut arr = arr;
        arr.sort_unstable_by(|a, b| {
            let a1 = a.count_ones();
            let b1 = b.count_ones();
            if a1 == b1 {
                a.cmp(b)
            } else {
                a1.cmp(&b1)
            }
        });
        arr
    }
}