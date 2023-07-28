impl Solution {
    pub fn get_winner(arr: Vec<i32>, k: i32) -> i32 {
        
        let mut k = k;
        let mut winner = arr[0];
        for i in 1..arr.len() {
            if k > 0 && winner > arr[i] {
                k -= 1;
            } else {
                winner = arr[i];
                k = 1;
            }
        }
        winner
    }
}