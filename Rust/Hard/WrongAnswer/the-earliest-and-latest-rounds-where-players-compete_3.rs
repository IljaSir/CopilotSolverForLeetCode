impl Solution {
    pub fn earliest_and_latest(n: i32, first_player: i32, second_player: i32) -> Vec<i32> {
        
        let mut lo = 1;
        let mut hi = n;
        let mut round = 0;
        while lo < hi {
            round += 1;
            let mid = (lo + hi) / 2;
            if (first_player <= mid && second_player > mid) || (first_player > mid && second_player <= mid) {
                return vec![round, round];
            } else if first_player <= mid && second_player <= mid {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        vec![round, round]
    }
}