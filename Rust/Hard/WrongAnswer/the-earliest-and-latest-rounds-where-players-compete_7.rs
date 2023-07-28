impl Solution {
    pub fn earliest_and_latest(n: i32, first_player: i32, second_player: i32) -> Vec<i32> {
        
        let mut l = 0;
        let mut r = n;
        let mut ans = vec![0, 0];
        let mut round = 0;
        while l < r {
            let mid = (l + r) / 2;
            round += 1;
            if (mid < first_player && mid < second_player) || (mid >= first_player && mid >= second_player) {
                l = mid + 1;
            } else {
                r = mid;
                ans[0] = round;
            }
        }
        ans[1] = round;
        ans
    }
}