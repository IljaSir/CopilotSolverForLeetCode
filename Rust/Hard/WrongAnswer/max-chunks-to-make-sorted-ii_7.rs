impl Solution {
    pub fn max_chunks_to_sorted(arr: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut res = 0;
        for (i, &a) in arr.iter().enumerate() {
            max = max.max(a);
            if i == max as usize {
                res += 1;
            }
        }
        res
    }
}