impl Solution {
    pub fn ship_within_days(weights: Vec<i32>, days: i32) -> i32 {
        
        let (mut left, mut right) = (weights.iter().max().unwrap(), weights.iter().sum::<i32>());
        while left < right {
            let mid = (left + right) / 2;
            if Solution::can_ship(weights.as_slice(), days, mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        left
    }
    fn can_ship(weights: &[i32], days: i32, capacity: i32) -> bool {
        let mut sum = 0;
        let mut days = days;
        for i in 0..weights.len() {
            sum += weights[i];
            if sum > capacity {
                days -= 1;
                sum = weights[i];
            }
        }
        days > 0
    }
}