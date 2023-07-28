impl Solution {
    pub fn get_winner(arr: Vec<i32>, k: i32) -> i32 {
        
        let mut max = arr[0];
        let mut win_count = 0;
        for i in 1..arr.len() {
            if arr[i] > max {
                win_count = 1;
                max = arr[i];
            } else {
                win_count += 1;
            }
            if win_count == k {
                break;
            }
        }
        max
    }
}