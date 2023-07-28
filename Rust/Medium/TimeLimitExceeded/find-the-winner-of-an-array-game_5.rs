impl Solution {
    pub fn get_winner(arr: Vec<i32>, k: i32) -> i32 {
        
        let mut arr = arr;
        let mut win_count = 0;
        while win_count < k {
            let a = arr.remove(0);
            let b = arr.remove(0);
            if a > b {
                arr.insert(0, a);
                arr.push(b);
                win_count += 1;
            } else {
                arr.insert(0, b);
                arr.push(a);
                win_count = 1;
            }
        }
        arr[0]
    }
}