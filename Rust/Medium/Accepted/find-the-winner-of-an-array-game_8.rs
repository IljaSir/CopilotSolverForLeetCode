impl Solution {
    pub fn get_winner(arr: Vec<i32>, k: i32) -> i32 {
        
        let mut k = k;
        let mut max = arr[0];
        let mut win_count = 0;
        for i in 1..arr.len() {
            let n = arr[i];
            if n > max {
                max = n;
                win_count = 0;
            }
            win_count += 1;
            if win_count == k {
                break;
            }
        }
        max
    }
}