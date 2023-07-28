impl Solution {
    pub fn three_consecutive_odds(arr: Vec<i32>) -> bool {
        
        let mut count = 0;
        for i in 0..arr.len() {
            if arr[i] % 2 != 0 {
                count += 1;
            } else {
                count = 0;
            }
            if count == 3 {
                return true;
            }
        }
        false
    }
}