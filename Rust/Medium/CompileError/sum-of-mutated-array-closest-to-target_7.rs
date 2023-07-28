impl Solution {
    pub fn find_best_value(arr: Vec<i32>, target: i32) -> i32 {
        
        let mut arr2 = arr.clone();
        arr2.sort();
        let mut sum = 0;
        let mut i = 0;
        let mut n = arr2.len();
        while i < n && sum + arr2[i] * (n - i) <= target {
            sum += arr2[i];
            i += 1;
        }
        if i == n {
            return arr2[n - 1];
        }
        let mut res = (target - sum) / (n - i) as i32;
        let mut diff = (target - sum) % (n - i) as i32;
        if diff * 2 > n - i {
            res += 1;
        }
        res
    }
}