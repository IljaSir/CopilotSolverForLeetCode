impl Solution {
    pub fn find_best_value(arr: Vec<i32>, target: i32) -> i32 {
        
        let (mut l, mut r) = (0, 100000);
        while l + 1 < r {
            let mid = (l + r) / 2;
            if Self::sum(arr.iter().map(|&x| if x > mid { mid } else { x }).collect(), target) {
                r = mid;
            } else {
                l = mid;
            }
        }
        if Self::sum(arr.iter().map(|&x| if x > l { l } else { x }).collect(), target) {
            l
        } else {
            r
        }
    }
    
    fn sum(arr: Vec<i32>, target: i32) -> bool {
        let mut sum = 0;
        for &x in arr.iter() {
            sum += x;
        }
        sum <= target
    }
}