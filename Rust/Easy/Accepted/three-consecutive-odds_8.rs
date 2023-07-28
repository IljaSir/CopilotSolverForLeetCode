impl Solution {
    pub fn three_consecutive_odds(arr: Vec<i32>) -> bool {
        
        let mut odds = 0;
        for i in 0..arr.len() {
            if arr[i] % 2 == 1 {
                odds += 1;
                if odds == 3 {
                    return true;
                }
            } else {
                odds = 0;
            }
        }
        false
    }
}