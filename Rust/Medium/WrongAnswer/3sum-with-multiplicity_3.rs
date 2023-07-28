impl Solution {
    pub fn three_sum_multi(arr: Vec<i32>, target: i32) -> i32 {
        
        let mut count = 0;
        let mut arr = arr;
        arr.sort();
        for i in 0..arr.len() {
            let mut left = i + 1;
            let mut right = arr.len() - 1;
            while left < right {
                let sum = arr[i] + arr[left] + arr[right];
                if sum == target {
                    count += 1;
                    left += 1;
                    right -= 1;
                } else if sum < target {
                    left += 1;
                } else {
                    right -= 1;
                }
            }
        }
        count
    }
}