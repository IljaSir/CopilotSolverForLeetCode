impl Solution {
    pub fn find_the_winner(n: i32, k: i32) -> i32 {
        
        let mut arr = vec![true; n as usize];
        let mut idx = 0;
        let mut cnt = 0;
        loop {
            if arr[idx] {
                cnt += 1;
                if cnt == k {
                    arr[idx] = false;
                    cnt = 0;
                }
            }
            if arr.iter().filter(|&x| *x).count() == 1 {
                break;
            }
            idx += 1;
            if idx == n as usize {
                idx = 0;
            }
        }
        arr.iter().position(|x| *x).unwrap() as i32 + 1
    }
}