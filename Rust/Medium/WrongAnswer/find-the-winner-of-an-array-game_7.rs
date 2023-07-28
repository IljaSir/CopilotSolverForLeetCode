impl Solution {
    pub fn get_winner(arr: Vec<i32>, k: i32) -> i32 {
        
        let mut arr = arr;
        let mut k = k;
        let mut win_count = 0;
        let mut winner = arr[0];
        while k > 0 {
            if winner > arr[1] {
                arr.push(arr[1]);
                arr.remove(1);
                win_count += 1;
            } else {
                arr.push(winner);
                arr.remove(0);
                winner = arr[0];
                win_count = 1;
            }
            if win_count == k {
                return winner;
            }
            k -= 1;
        }
        winner
    }
}