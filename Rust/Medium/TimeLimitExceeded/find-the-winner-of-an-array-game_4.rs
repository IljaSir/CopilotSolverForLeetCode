impl Solution {
    pub fn get_winner(arr: Vec<i32>, k: i32) -> i32 {
        
        let mut arr = arr;
        let mut winner = arr[0];
        let mut win_count = 0;
        let mut i = 1;
        while win_count < k {
            if arr[i] > winner {
                winner = arr[i];
                win_count = 1;
            } else {
                win_count += 1;
            }
            arr.push(arr[i]);
            i += 1;
        }
        winner
    }
}