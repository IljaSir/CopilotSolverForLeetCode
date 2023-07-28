impl Solution {
    pub fn earliest_and_latest(n: i32, first_player: i32, second_player: i32) -> Vec<i32> {
        
        let mut first = first_player;
        let mut second = second_player;
        if first > second {
            std::mem::swap(&mut first, &mut second);
        }
        let mut round = 0;
        let mut left = 1;
        let mut right = n;
        let mut earliest = 0;
        let mut latest = 0;
        while left < right {
            round += 1;
            let mid = (left + right) >> 1;
            if first <= mid && second > mid {
                earliest = round;
                latest = round;
            } else if first > mid {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if earliest == 0 {
            earliest = round;
        }
        if latest == 0 {
            latest = round;
        }
        vec![earliest, latest]
    }
}