impl Solution {
    pub fn count_triplets(arr: Vec<i32>) -> i32 {
        
        let mut cnt = 0;
        for i in 0..arr.len() {
            let mut x = 0;
            for k in i..arr.len() {
                x ^= arr[k];
                if x == 0 && k > i {
                    cnt += k - i;
                }
            }
        }
        cnt as i32
    }
}