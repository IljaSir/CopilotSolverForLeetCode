impl Solution {
    pub fn find_best_value(arr: Vec<i32>, target: i32) -> i32 {
        
        let mut arr = arr;
        arr.sort();
        let mut sum = 0;
        let mut i = 0;
        while i < arr.len() && sum + arr[i] * (arr.len() - i) as i32 <= target {
            sum += arr[i];
            i += 1;
        }
        if i == arr.len() {
            return arr[arr.len() - 1];
        }
        let mut res = (target - sum) / (arr.len() - i) as i32;
        if (res + 1) * (arr.len() - i) as i32 + sum - target < target - sum - res * (arr.len() - i) as i32 {
            res += 1;
        }
        res
    }
}