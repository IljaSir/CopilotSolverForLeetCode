impl Solution {
    pub fn find_best_value(arr: Vec<i32>, target: i32) -> i32 {
        
        let mut arr = arr;
        arr.sort();
        let mut sum = 0;
        let mut ans = 0;
        let mut diff = target;
        for (i, &v) in arr.iter().enumerate() {
            let n = arr.len() - i;
            let t = target - sum - v * n as i32;
            if t > 0 {
                sum += v;
            } else {
                let t = target - sum;
                if t % n as i32 == 0 {
                    return t / n as i32;
                }
                return t / n as i32 + 1;
            }
        }
        arr[arr.len() - 1]
    }
}