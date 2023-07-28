impl Solution {
    pub fn get_winner(arr: Vec<i32>, k: i32) -> i32 {
        
        let mut k = k;
        let mut i = 0;
        let mut j = 1;
        let mut win_count = 0;
        let mut winner = arr[0];
        let mut n = arr.len();
        while win_count < k {
            if arr[i] > arr[j] {
                win_count += 1;
                winner = arr[i];
                j += 1;
                if j == n {
                    j = 0;
                }
            } else {
                let tmp = i;
                i = j;
                j = tmp;
                win_count = 1;
                winner = arr[i];
                j += 1;
                if j == n {
                    j = 0;
                }
            }
        }
        winner
    }
}