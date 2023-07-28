impl Solution {
    pub fn find_best_value(arr: Vec<i32>, target: i32) -> i32 {
        
        let mut arr = arr;
        arr.sort();
        let mut sum = 0;
        let mut ans = 0;
        let mut diff = target;
        for (i, &a) in arr.iter().enumerate() {
            let t = (arr.len() - i) as i32 * a;
            if sum + t > target {
                let d = (target - sum) / (arr.len() - i) as i32;
                let cur_diff = (target - sum - d * (arr.len() - i) as i32).abs();
                if cur_diff < diff {
                    ans = d;
                    diff = cur_diff;
                } else if cur_diff == diff && ans > d {
                    ans = d;
                }
                break;
            }
            sum += a;
            let cur_diff = (target - sum).abs();
            if cur_diff < diff {
                ans = a;
                diff = cur_diff;
            }
        }
        ans
    }
}